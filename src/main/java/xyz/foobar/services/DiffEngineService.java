package xyz.foobar.services;

import java.awt.BufferCapabilities.FlipContents;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xyz.foobar.Diff;
import xyz.foobar.DiffEngine;
import xyz.foobar.DiffException;

public class DiffEngineService implements DiffEngine {

	public <T extends Serializable> T apply(T original, Diff<?> diff) throws DiffException {

		if (diff == null || (diff != null && diff.getObj() == null))
			return null;

		T clone = original == null ? (T) diff.getObj() : original;

		for (String field : diff.getFields()) {
			try {
				Field field1 = original.getClass().getDeclaredField(field);
				field1.setAccessible(true);
				field1.set(clone, field1.get(diff.getObj()));
			} catch (IllegalAccessException e) {
				throw new DiffException();
			} catch (NoSuchFieldException e) {
				throw new DiffException();
			}
		}
		return clone;
	}

	public <T extends Serializable> Diff<T> calculate(T original, T modified) throws DiffException {

		List<String> fields = new ArrayList<String>();
		Diff<T> diff = null;

		//  Creating Object For the First TIme
		if (original == null && modified != null) {
			diff = new Diff<T>();
			diff.setObj(modified);

			int index = 1;
			String value = "";
			// diff.getObj().getClass().getName();
			for (Field field : Arrays.asList(modified.getClass().getDeclaredFields())) {

				value = "1." + index + "Created : " + field.getName();
				++index;

				diff.setParent(field.getName());

				fields.add(value);
				value = modified.getClass().getName();
			}
			fields.add(0, value);
			diff.setFields(fields);

			return diff;
		} /////////////
		if (original != null) {

			diff = new Diff<T>();
			diff.setObj(original);

			for (Field field : Arrays.asList(modified.getClass().getDeclaredFields())) {

				diff.setParent(field.getName());

				// Here is to Check Modified Fileds
				fields.add(field.getName());
			}
			diff.setFields(fields);
		} else if (modified != null) {

		}
		return diff;
	}

}
