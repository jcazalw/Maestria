package foo.util;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import foo.domain.ArticulosFamilias;
//http://www.javahispano.org/java-ee/post/1611099
public class TreeUtils {
	public static TreeNode popularArbol(TreeNode nodoPadre, List<ArticulosFamilias> datos, Class<?> clase, String methodName) {
		for (int i = 0; i < datos.size(); i++) {
			ArticulosFamilias dato =  datos.get(i);
			ArticulosFamilias padreDeDato = dato.getAncestroId();
			if ((nodoPadre.getData() == null) && (padreDeDato == null)) {
				System.out.println("nodo Null");
				TreeNode nodo = new DefaultTreeNode(dato, nodoPadre);
				nodo.setExpanded(true);
				popularArbol(nodo, datos, clase, methodName);
			}else {
				if (padreDeDato != null) {

					if (padreDeDato.getId().equals(((ArticulosFamilias)nodoPadre.getData()).getId()) ) {
						TreeNode nodo = new DefaultTreeNode(dato, nodoPadre);
						nodo.setExpanded(true);
						popularArbol(nodo, datos, clase, methodName);
					}

				}				
			}
		}
		return nodoPadre;
	}

	private static Object obtenerRetornoInvocado(Object object, String methodName) {
		try {
			return object.getClass().getMethod(methodName).invoke(object);
		} catch (Exception ex) {
			Logger.getLogger(TreeUtils.class.getName()).log(Level.ERROR, null, ex);
		}
		return null;
	}
}

