package haven.sprites;

import haven.*;
import haven.Composite;
import haven.render.Pipe;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class LinePathSprite extends Sprite implements PView.Render2D {


    public static Color MAINCOLOR = Color.WHITE;
    public static Color FOECOLOR = Color.red;
    public static Color FRIENDCOLOR = Color.green;
    public static Color UNKNOWNCOLOR = Color.gray;
    private final LinMove linMove;

    public LinePathSprite(Gob gob, LinMove linMove) {
        super(gob, null);
        this.linMove = linMove;
    }

    private static final String[] IGNOREDCHASEVECTORS = {
            "gfx/terobjs/vehicle/cart",
            "gfx/terobjs/vehicle/wagon",
            "gfx/terobjs/vehicle/wheelbarrow",
    };

    public void draw(GOut g, Pipe state) {
        if (OptWnd.drawPathVectorCheckBox.a) {
            try {
                Gob gob = (Gob) owner;
                UI ui = gob.glob.sess.ui;
                if (ui != null) {
                    MapView mv = ui.gui.map;
                    if (mv != null) {
                        Moving lm = gob.getattr(Moving.class);
                        if (lm != null) {
                            Coord2d mc = mv.pllastcc;
                            if (mc != null) {
                                if (gob == ui.gui.map.player()) {
                                    final Coord3f pc = gob.getc();
                                    Coord pla = pc.round2();
                                    double x = mc.x - pc.x;
                                    double y = -(mc.y - pc.y);
                                    Coord ChaserCoord = mv.screenxf(pc).round2();
                                    Coord TargetCoord = mv.screenxf(mc).round2();
                                    Color chaserColor = MAINCOLOR;
                                    g.chcolor(MAINCOLOR);
                                    g.line(ChaserCoord, TargetCoord, 1.5);
                                }
                                if (gob.getres().name.equals("gfx/terobjs/vehicle/snekkja")) {
                                    for (Gob occupant : gob.occupants) {
                                        if (occupant.getPoses().contains("snekkjaman0")) {
                                            if (occupant.isMe()) {
                                                final Coord3f pc = gob.getc();
                                                Coord pla = pc.round2();
                                                double x = mc.x - pc.x;
                                                double y = -(mc.y - pc.y);
                                                Coord ChaserCoord = mv.screenxf(pc).round2();
                                                Coord TargetCoord = mv.screenxf(mc).round2();
                                                Color chaserColor = MAINCOLOR;
                                                g.chcolor(MAINCOLOR);
                                                g.line(ChaserCoord, TargetCoord, 1.5);
                                            }
                                        }
                                    }
                                }
                                if (gob.getres().name.equals("gfx/terobjs/vehicle/knarr")) {
                                    for (Gob occupant : gob.occupants) {
                                        if (occupant.getPoses().contains("knarrman9")) {
                                            if (occupant.isMe()) {
                                                final Coord3f pc = gob.getc();
                                                Coord pla = pc.round2();
                                                double x = mc.x - pc.x;
                                                double y = -(mc.y - pc.y);
                                                Coord ChaserCoord = mv.screenxf(pc).round2();
                                                Coord TargetCoord = mv.screenxf(mc).round2();
                                                Color chaserColor = MAINCOLOR;
                                                g.chcolor(MAINCOLOR);
                                                g.line(ChaserCoord, TargetCoord, 1.5);
                                            }
                                        }
                                    }
                                }
                                if (gob.getres().name.equals("gfx/terobjs/vehicle/rowboat")) {
                                    for (Gob occupant : gob.occupants) {
                                        if (occupant.getPoses().contains("rowboat-d") || occupant.getPoses().contains("rowing")) {
                                            if (occupant.isMe()) {
                                                final Coord3f pc = gob.getc();
                                                Coord pla = pc.round2();
                                                double x = mc.x - pc.x;
                                                double y = -(mc.y - pc.y);
                                                Coord ChaserCoord = mv.screenxf(pc).round2();
                                                Coord TargetCoord = mv.screenxf(mc).round2();
                                                Color chaserColor = MAINCOLOR;
                                                g.chcolor(MAINCOLOR);
                                                g.line(ChaserCoord, TargetCoord, 1.5);
                                            }
                                        }
                                    }
                                }
                                if (gob.getres().name.equals("gfx/terobjs/vehicle/coracle")) {
                                    for (Gob occupant : gob.occupants) {
                                        if (occupant.getPoses().contains("coracle-idle") || occupant.getPoses().contains("coraclerowan")) {
                                            if (occupant.isMe()) {
                                                final Coord3f pc = gob.getc();
                                                Coord pla = pc.round2();
                                                double x = mc.x - pc.x;
                                                double y = -(mc.y - pc.y);
                                                Coord ChaserCoord = mv.screenxf(pc).round2();
                                                Coord TargetCoord = mv.screenxf(mc).round2();
                                                Color chaserColor = MAINCOLOR;
                                                g.chcolor(MAINCOLOR);
                                                g.line(ChaserCoord, TargetCoord, 1.5);
                                            }
                                        }
                                    }
                                }
                                if (gob.getres().name.equals("gfx/kritter/horse/stallion") || gob.getres().name.equals("gfx/kritter/horse/mare")) {
                                    for (Gob occupant : gob.occupants) {
                                        if (occupant.getPoses().contains("riding-idle") || occupant.getPoses().contains("riding-trot") || occupant.getPoses().contains("riding-gallop")) {
                                            if (occupant.isMe()) {
                                                final Coord3f pc = gob.getc();
                                                Coord pla = pc.round2();
                                                double x = mc.x - pc.x;
                                                double y = -(mc.y - pc.y);
                                                Coord ChaserCoord = mv.screenxf(pc).round2();
                                                Coord TargetCoord = mv.screenxf(mc).round2();
                                                Color chaserColor = MAINCOLOR;
                                                g.chcolor(MAINCOLOR);
                                                g.line(ChaserCoord, TargetCoord, 1.5);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }
}
