package cac.crud22034.modelo;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class ModeloFactory {

    private ModeloFactory() {}
    
    private static ModeloFactory mf = null;

    public static ModeloFactory getInstance() {
        if (mf == null) {
            mf = new ModeloFactory();
        }
        return mf;
    }

    public ModeloP crearModelo(String nombreModelo) {
        ModeloP m = null;
        String nombreClase = mf.getClass().getPackage().getName() + ".ModeloP" + nombreModelo;
        try {
            m = (ModeloP) Class.forName(nombreClase).getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Ocurrió un error al instanciar un modelo de tipo " + nombreClase, ex);
        }
        return m;
    }
}
