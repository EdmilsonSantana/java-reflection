
package exemplos;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapaDeClasses {

	private Map<String, String> mapa = new HashMap<>();

	public Class<?> getClass(String chave) throws Exception {

		String valor = mapa.get(chave);
		if (valor != null) {
			return Class.forName(valor);
		} else {
			throw new RuntimeException("Chave inválida");
		}
	}

	public Object getObject(String chave) throws Exception {

		return this.getClass(chave).newInstance();
	}

	public <E> E getObject(String chave, Object[] params) throws Exception {

		Class<?> klass = this.getClass(chave);
		Class<?>[] parameterTypes = new Class<?>[params.length];
		for (int i = 0; i < params.length; i++) {
			parameterTypes[i] = params[i].getClass();
		}
		Constructor<?> constructor = klass.getConstructor(parameterTypes);
		return (E) constructor.newInstance(params);

	}

	public List<String> getAtributosString(Object o, String str) {

		try {
			List<String> lista = new ArrayList<>();
			Class<?> c = o.getClass();
			for (Field f : c.getFields()) {
				Object value = f.get(o);
				if (value != null) {
					String strValue = value.toString();
					if (strValue.contains(str)) {
						lista.add(f.getName());
					}
				}
			}
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
