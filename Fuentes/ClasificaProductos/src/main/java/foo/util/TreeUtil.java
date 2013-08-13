package foo.util;



import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import foo.domain.ArticulosFamilias;

public class TreeUtil {

	public static void pupularArbol(TreeNode nodoPadre, List<ArticulosFamilias> datos, Class clase, String methodName) {
		for (int i = 0; i < datos.size(); i++) {
			Object dato = datos.get(i);
			Object padreDeDato = obtenerRetornoInvocado(dato, methodName);
			if ((nodoPadre.getData() == null) && (padreDeDato == null)) {
				TreeNode nodo = new DefaultTreeNode(dato, nodoPadre);
				nodo.setExpanded(true);
				pupularArbol(nodo, datos, clase, methodName);
			}else {
				if (padreDeDato != null) {
					if (padreDeDato.equals(nodoPadre.getData())) {
						TreeNode nodo = new DefaultTreeNode(dato, nodoPadre);
						nodo.setExpanded(true);
						pupularArbol(nodo, datos, clase, methodName);
					}
				}
			}
		}
	}

	private static Object obtenerRetornoInvocado(Object object, String methodName) {
		try {
			return object.getClass().getMethod(methodName).invoke(object);
		} catch (Exception ex) {
			Logger.getLogger(TreeUtil.class.getName()).log(Level.FATAL, null, ex);
		}
		return null;
	}
}