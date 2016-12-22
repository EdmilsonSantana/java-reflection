package exemplos;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Mapeador {

	private Map<Class<?>, Class<?>> mapa = new HashMap<>();

	public void load(String nomeArquivo) throws Exception {

		Properties p = new Properties();
		p.load(new FileInputStream(nomeArquivo));
		for (Object key : p.keySet()) {
			Class<?> interf = Class.forName(key.toString());
			Class<?> impl = Class.forName(p.get(key).toString());
			if (!interf.isInterface()) {
				throw new RuntimeException("O tipo " + interf.getName() + " não é uma interface");
			}
			if (!interf.isAssignableFrom(impl)) {
				throw new RuntimeException("A classe " + impl.getName() + " não implementa " + interf.getName());
			}
			mapa.put(interf, impl);
		}
	}

	public Class<?> getImplementacao(Class<?> interf) {

		return mapa.get(interf);
	}

	public <E> E getInstancia(Class<E> interf) throws Exception {
		Class<?> impl = this.getImplementacao(interf);
		return (E) impl.newInstance();
	}
	
	public <E> E getInstancia(Class<E> interf, Object... params) throws Exception {
		Class<?> impl = this.getImplementacao(interf);
		Class<?>[] tiposConstrutor = new Class<?>[params.length];
		for (int i=0; i < tiposConstrutor.length; i++) {
			tiposConstrutor[i] = params[i].getClass();
		}
		Constructor<?> c = impl.getConstructor(tiposConstrutor);	
		return (E) c.newInstance(params);
	}
 }
