package xyz.foobar.services;

import xyz.foobar.Diff;
import xyz.foobar.DiffException;
import xyz.foobar.DiffRenderer;

public class DiffRendererService implements DiffRenderer {

	public String render(Diff<?> diff) throws DiffException {
		System.out.println(diff);
		
		return diff.getClass().getName();
	}

}
