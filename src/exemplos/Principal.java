package exemplos;
import java.util.List;
import java.util.Map;

public class Principal {
	public static void main(String[] args) throws Exception {

		Mapeador mapeador = new Mapeador();
		mapeador.load("classes.prop");
		
		System.out.println(mapeador.getImplementacao(List.class));
		System.out.println(mapeador.getImplementacao(Map.class));
		
		InterfaceExemplo exemplo = mapeador.getInstancia(InterfaceExemplo.class, "Str");
		
		System.out.println(exemplo.getClass());
		
		
	}
}
