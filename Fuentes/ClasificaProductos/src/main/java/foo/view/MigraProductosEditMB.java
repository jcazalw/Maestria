package foo.view;

import javax.inject.Inject;

import foo.business.MigraProductosBC;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./migraProductos_list.xhtml")
public class MigraProductosEditMB extends AbstractEditPageBean<MigraProductosEditMB, Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	MigraProductosBC migraProductos;
	
	@Override
	@Transactional
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public String insert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	protected void handleLoad() {
		// TODO Auto-generated method stub
		
	}

}
