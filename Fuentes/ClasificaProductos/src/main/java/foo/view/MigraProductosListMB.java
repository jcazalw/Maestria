package foo.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import org.dom4j.tree.DefaultAttribute;
import org.primefaces.component.behavior.ajax.AjaxBehavior;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import foo.business.ArticulosFamiliasBC;
import foo.business.MigraProductosBC;
import foo.domain.ArticulosFamilias;
import foo.domain.MigraProductos;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import foo.exception.ApplicationRuntimeException;
import foo.util.tree.NodeBean;

@ViewController
@NextView("./migraProductos_edit.xhtml")
@PreviousView("./migraProductos_list.xhtml")
public class MigraProductosListMB extends AbstractListPageBean<MigraProductos, Integer> {	

	@Inject
	MigraProductosBC mpBC;

	@Inject
	ArticulosFamiliasBC afBC;

	@Inject
	NodeBean nodeBean;

	private TreeNode selectedNode;
	private TreeNode categoriesTree;

	private List<MigraProductos> droppedProducts = new ArrayList<MigraProductos>();
	private List<MigraProductos> notCategorizedList = new ArrayList<MigraProductos>();

	private MigraProductos selectedItem;

	private static final long serialVersionUID = 1L;

	@Override
	protected List<MigraProductos> handleResultList() {		
		return this.mpBC.findAll();
	}
	
	/*Gestiona el Drop de los productos*/

	@PostConstruct
	public void init() {
		try {
			categoriesTree = nodeBean.populateTree();
			setNotCategorizedList(mpBC.findNotCategorized());
		} catch (ApplicationRuntimeException e) {
			throw e;
		}
	}
	

	//@Transactional TreeNode node, List<ArticulosFamilias> lista
	/*Listeners*/
	
	public void valueChangeMethod(ValueChangeEvent e){		
		this.clear();
		for (Iterator<Integer> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Integer id = iter.next();
			getSelection().put(id,true);
		}
		
		
	}
	public void addToDropped(){		
		boolean selected;
		for (Iterator<Integer> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Integer id = iter.next();
			selected = getSelection().get(id);
			if (selected) {
				MigraProductos e = this.mpBC.load(id);
				droppedProducts.add(e);
				getNotCategorizedList().remove(e); 
				iter.remove();
			}
		}
	}
	
	public void resetDroppedList(){
		this.droppedProducts = new ArrayList<MigraProductos>();
	}

	@Transactional
	public String categorizarProducto(){		
		if (this.getSelectedNode() != null) { 
			ArticulosFamilias art = (ArticulosFamilias)nodeBean.getArtiByDescripcionHM().get(selectedNode.getData().toString());
			System.out.println(selectedNode.getData().toString());
			if (art != null){
				for (MigraProductos p : droppedProducts) {
					p.setArticuloFamiliaId(art);
					this.mpBC.update(p);
				}
				setNotCategorizedList(mpBC.findNotCategorized());
				this.droppedProducts = new ArrayList<MigraProductos>();
				this.showNotification("Operacion Exitosa");
				return getCurrentView();
			}
		}else
			this.showNotification("Debe seleccionar categoría");		
		return "";
	}
	
	@Transactional
	public String setEstadoProducto(String estado ){		
		boolean selected;
		for (Iterator<Integer> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Integer id = iter.next();
			selected = getSelection().get(id);
			if (selected) {
				MigraProductos e = this.mpBC.load(id);
				e.setSuspendido(estado);
				this.mpBC.update(e);
				iter.remove();
			}
		}
		this.clear();
		this.showNotification("Operacion Exitosa");
		return "./allProductsList.xhtml";
	}
	
	@Transactional
	public String descategorizar(){		
		boolean selected;
		for (Iterator<Integer> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Integer id = iter.next();
			selected = getSelection().get(id);
			if (selected) {
				MigraProductos e = this.mpBC.load(id);
				//ArticulosFamilias f = new ArticulosFamilias();
				e.setArticuloFamiliaId(null);				
				this.mpBC.update(e);				
				iter.remove();
			}
		}
		refresh();
		this.showNotification("Operacion Exitosa");
		return "./allProductsList.xhtml";
		
	}
	
	public void refresh(){
		this.clear();
		setNotCategorizedList(mpBC.findNotCategorized());
	}

	public void onItemDrop(DragDropEvent ddEvent) {  
		MigraProductos item = ((MigraProductos) ddEvent.getData());	
		droppedProducts.add(item);		
		getResultList().remove(item);  
	}

	public void onNodeSelect(NodeSelectEvent event) {	
		if (event.getTreeNode() != null)
			this.selectedNode = event.getTreeNode();
	}
	
	public void showNotification(String notification){
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, notification.toString(),"");		  
         FacesContext.getCurrentInstance().addMessage(null, message); 
	}

	public MigraProductos getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(MigraProductos selectedItem) {
		this.selectedItem = selectedItem;
	}

	public List<MigraProductos> getDroppedProducts() {
		return droppedProducts;
	}

	public void setDroppedProducts(List<MigraProductos> droppedProducts) {
		this.droppedProducts = droppedProducts;
	}

	public TreeNode getSelectedNode() {
		return this.selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {	
		this.selectedNode = selectedNode;
	}

	public TreeNode getCategoriesTree() {
		return categoriesTree;
	}

	public void setCategoriesTree(TreeNode categoriesTree) {
		this.categoriesTree = categoriesTree;
	}



	public List<MigraProductos> getNotCategorizedList() {
		return notCategorizedList;
	}



	public void setNotCategorizedList(List<MigraProductos> notCategorizedList) {
		this.notCategorizedList = notCategorizedList;
	}
}
