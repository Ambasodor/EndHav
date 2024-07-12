package auto;

import haven.Coord2d;
import haven.GameUI;
import haven.Gob;
import haven.GobTag;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GobHelper {
    static List<ITarget> getNearest(GameUI gui, String name, int limit, double distance) {
	return getGobs(gui, limit, PositionHelper.byDistanceToPlayer, gobIs(name), gob -> PositionHelper.distanceToPlayer(gob) <= distance);
    }
    
    static List<ITarget> getNearest(GameUI gui, GobTag tag, int limit, double distance) {
	return getGobs(gui, limit, PositionHelper.byDistanceToPlayer, gobIs(tag), gob -> PositionHelper.distanceToPlayer(gob) <= distance);
    }
    
    static List<ITarget> getNearestToPoint(GameUI gui, GobTag tag, int limit, Coord2d pos, double distance) {
	return getNearest(gui, tag, limit, g -> PositionHelper.distanceToCoord(pos, g), distance);
    }
    
    private static List<ITarget> getNearest(GameUI gui, GobTag tag, int limit, Function<Gob, Double> meter, double distance) {
	return getGobs(gui, limit, Comparator.comparingDouble(meter::apply), gobIs(tag), gob -> meter.apply(gob) <= distance);
    }
    
    @SafeVarargs
    private static List<ITarget> getGobs(GameUI gui, int limit, Comparator<Gob> sort, Predicate<Gob>... filters) {
	Stream<Gob> stream = gui.ui.sess.glob.oc.stream();
	for (Predicate<Gob> filter : filters) {
	    stream = stream.filter(filter);
	}
	return stream
	    .sorted(sort)
	    .limit(limit)
	    .map(GobTarget::new)
	    .collect(Collectors.toList());
    }
    
    static Bot.BotAction waitGobNoPose(Gob gob, long timeout, String... poses) {
	return (t, b) -> {
	    final long started = System.currentTimeMillis();
	    while (System.currentTimeMillis() - started < timeout
		&& gob != null && !gob.disposed() && gob.hasPose(poses)) {
		Bot.pause(100);
	    }
	};
    }
    
    static Bot.BotAction waitGobPose(Gob gob, long timeout, String... poses) {
	return (t, b) -> {
	    final long started = System.currentTimeMillis();
	    while (System.currentTimeMillis() - started < timeout
		&& gob != null && !gob.disposed() && !gob.hasPose(poses)) {
		Bot.pause(100);
	    }
	};
    }
    
    private static Predicate<Gob> gobIs(String what) {
	return g -> {
	    if(g == null) {return false;}
	    String id = g.resid();
	    if(id == null) {return false;}
	    return id.contains(what);
	};
    }
    
    public static Predicate<Gob> gobIs(GobTag what) {
	return g -> {
	    if(g == null) {return false;}
	    return g.is(what);
	};
    }
}
