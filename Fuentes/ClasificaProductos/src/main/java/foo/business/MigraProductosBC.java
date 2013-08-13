package foo.business;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import foo.domain.ArticulosFamilias;
import foo.domain.Bookmark;
import foo.domain.MigraProductos;
import foo.persistence.ArticulosFamiliasDAO;
import foo.persistence.MigraProductosDAO;
import foo.util.TreeUtils;
import foo.util.tree.NodeBean;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class MigraProductosBC extends DelegateCrud<MigraProductos, Integer, MigraProductosDAO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	ArticulosFamiliasDAO afDAO;
	@Inject
	MigraProductosDAO mpDAO;	 
	

	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {	
				
		}
	}
	
	public List<MigraProductos> findNotCategorized(){
		return mpDAO.findNotCategorized();
	}
	
	
	//	public TreeNode populateCategoriesTree(){
	//		List<ArticulosFamilias> listaCat;
	//		List<ArticulosFamilias> listaHijos;
	//
	//		if (!afDAO.getFamiliaByNivel(1).isEmpty()) {
	//			root = new DefaultTreeNode("root", null);
	//			TreeNode nodo;			
	//			listaCat = afDAO.getFamiliaByNivel(1);
	//
	//			for (ArticulosFamilias item : listaCat) {
	//				
	//				nodo = new DefaultTreeNode(item.getFamilia(),root);				
	//				
	//				if (!item.getArticulosFamiliasList().isEmpty()){
	//					TreeNode branches = nodo;
	//					TreeNode leaves;					
	//					listaHijos = item.getArticulosFamiliasList();
	//					Iterator<ArticulosFamilias> iter = listaHijos.iterator();
	//					int i = 0;
	//					while (iter.hasNext()) {
	//						ArticulosFamilias af = (ArticulosFamilias) iter
	//								.next();
	//						leaves = new DefaultTreeNode(af.getFamilia(), branches);
	//						i++;
	//						if (listaHijos.size() == i-1){						
	//							if 	(!af.getArticulosFamiliasList().isEmpty() ){
	//								System.out.println("llega");
	//								listaHijos = af.getArticulosFamiliasList();
	//								iter = listaHijos.iterator();
	//								i = 0;
	//								branches = leaves;
	//							}								
	//						}
	//					}				
	//				}
	//			}
	//			return root;
	//		}
	//		else return null;		
	//	}



}






