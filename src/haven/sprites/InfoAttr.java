package haven.sprites;

import haven.*;
import haven.render.Homo3D;
import haven.render.Pipe;

import java.awt.*;

public class InfoAttr extends GAttrib implements PView.Render2D {
    Indir<Resource> res;
    public InfoAttr(Gob gob, Indir<Resource> res) {
	super(gob);
	this.res = res;
    }
    
    @Override
    public void draw(GOut g, Pipe state) {
	try {
	    Coord sc = Homo3D.obj2view(new Coord3f(0, 0, 15), state, Area.sized(g.sz())).round2();
	    FastText.aprint(g,sc, 0.5,0.5, String.valueOf(res.get()));
	} catch (Loading e) {
	}
    }
}
