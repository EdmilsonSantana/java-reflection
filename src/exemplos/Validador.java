
package exemplos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Validador {

	public static boolean validarObjeto(Object obj) throws Exception {

		Boolean resultado = true;

		Class<?> clazz = obj.getClass();

		for (Method m : clazz.getMethods()) {
			if (m.getName().startsWith("validar") && m.getReturnType() == boolean.class && m.getParameterTypes().length == 0) {
				Boolean retorno = (Boolean) m.invoke(obj);
				resultado = resultado && retorno.booleanValue();
			}
		}

		return resultado;
	}

	public static void invocaTeste(Object obj) throws Throwable {

		Class<?> clazz = obj.getClass();
		for (Method m : clazz.getMethods()) {
			if (m.getName().startsWith("test") && m.getReturnType() == void.class && m.getParameterTypes().length == 0) {
				try {
					m.invoke(obj);
					System.out.println("Método de teste invocado");
				} catch (InvocationTargetException ex) {
					throw ex.getTargetException();
				}
			}
		}
	}

	public static void main(String[] args) throws Throwable {

		Usuario usuario = new Usuario();
		usuario.setLogin("edmilson");
		usuario.setSenha("123456789");
		usuario.setEmail("edmilsonsantana@2hotmail.com");
		usuario.setPapel("professor");
		usuario.setAtivo(Boolean.TRUE);

		Boolean valido = Validador.validarObjeto(usuario);

		if (valido) {
			System.out.println("O objeto é válido");
		} else {
			System.out.println("O objeto é inválido");
		}
		
		Validador.invocaTeste(usuario);
	}

}
