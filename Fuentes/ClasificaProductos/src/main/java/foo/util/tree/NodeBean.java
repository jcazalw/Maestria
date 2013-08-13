/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package foo.util.tree;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;

import foo.domain.ArticulosFamilias;
import foo.persistence.ArticulosFamiliasDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.NodeSelectEvent;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;


/**
 *
 * @author ubuntu
 */
@BusinessController
public class NodeBean {

	private TreeNode root;
	private TreeNode donanim;
	private TreeNode selectedNode;
	private static  List<ArticulosFamilias> liste;
	private static List<ArticulosFamilias> araListe;

	@Inject
	private ArticulosFamiliasDAO afDAO;
	private ArticulosFamilias katNesnesi;
	private List<ArticulosFamilias> subList2;
	private String kategIsmi;
	private HashMap<String, ArticulosFamilias> artiByDescripcionHM;
	
	public NodeBean() {
	}
	//Dynamic tree viewi olutruan method.
	public  void recursive(Integer id,TreeNode node){
		subList2=new ArrayList<ArticulosFamilias>();
		subList2=subKategori(id);
		for(ArticulosFamilias k:subList2){		
			TreeNode childNode=new DefaultTreeNode(k.getFamilia(), node);
			childNode.setSelectable(true);
			recursive(k.getId(),childNode);
		}

	}
	//herhangi bir tree nodenin childlarini buluyor.
	public static List<ArticulosFamilias> subKategori(Integer i)
	{
		araListe=new ArrayList<ArticulosFamilias>();
		for(ArticulosFamilias k:getListe()){			
			if(k.getPadre() != null && k.getPadre().equals(i)){
				araListe.add(k);
			}
		}
		return araListe;
	}
	public static List<ArticulosFamilias> getListe() {
		return liste;
	}
	public ArticulosFamilias getKatNesnesi() {
		return katNesnesi;
	}
	public void setKatNesnesi(ArticulosFamilias katNesnesi) {
		this.katNesnesi = katNesnesi;
	}
	public TreeNode getRoot() {
		return root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}
	public void secilenNode(NodeSelectEvent event){
		FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "selected", event.getTreeNode().getData().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String getKategIsmi() {
		return kategIsmi;
	}

	public void setKategIsmi(String kategIsmi) {
		this.kategIsmi = kategIsmi;
	}

	public TreeNode populateTree(){
		liste=new ArrayList<ArticulosFamilias>();		
		root=new DefaultTreeNode("Root",null);		
		liste=afDAO.findAll();		
		donanim=new DefaultTreeNode("", root);		
		recursive(0,donanim);
		donanim.setSelectable(true);
		artiByDescripcionHM = new HashMap<String, ArticulosFamilias>();
		for (ArticulosFamilias item : liste) {
			artiByDescripcionHM.put(item.getFamilia(), item);
		}
		return donanim;
	}
	
	public HashMap getArtiByDescripcionHM() {
		return artiByDescripcionHM;
	}
	
	public void setArtiByDescripcionHM(HashMap artiByDescripcionHM) {
		this.artiByDescripcionHM = artiByDescripcionHM;
	}

	}
