package exemplos;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GeradorXML {

	public static Map<String, Object> getAtributos(Object obj) throws Exception {
		Class<?> klass = obj.getClass();
		Field[] fields = klass.getDeclaredFields();
		Map<String, Object> mapa = new HashMap<String, Object>();
		for ( Field field : fields){
			field.setAccessible(Boolean.TRUE);
			mapa.put(field.getName(), field.get(obj));
		}
		return  mapa;
	}
	
	public static String getXML(Object obj) throws Exception {

		StringBuilder sb = new StringBuilder();

		Class<?> klass = obj.getClass();

		sb.append("<" + klass.getSimpleName() + "> \n");

		for (Field field : klass.getDeclaredFields()) {
			field.setAccessible(Boolean.TRUE);
			sb.append("<" + field.getName() + ">");
			sb.append(field.get(obj));
			sb.append("</" + field.getName() + "> \n");
		}

		sb.append("</" + klass.getSimpleName() + "> \n");
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setLogin("edmilson");
		usuario.setSenha("ed123");
		usuario.setEmail("edmilsonsantana2@hotmail.com");
		usuario.setPapel("professor");
		usuario.setAtivo(Boolean.TRUE);
		
		String xml = getXML(usuario);
		
		System.out.println(xml);
		
		Map<String, Object> atributos = getAtributos(usuario);
		Iterator<String> iterator = atributos.keySet().iterator();
		while ( iterator.hasNext() ) {
			String atributo = iterator.next();
			System.out.println("Atributo: " + atributo + " Valor: " + atributos.get(atributo) );
		}
		
	}
}
