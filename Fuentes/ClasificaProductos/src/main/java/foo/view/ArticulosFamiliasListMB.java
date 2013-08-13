package foo.view;

import java.util.List;

import javax.inject.Inject;

import foo.business.ArticulosFamiliasBC;
import foo.domain.ArticulosFamilias;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;

@ViewController
public class ArticulosFamiliasListMB extends AbstractListPageBean<ArticulosFamilias, Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	ArticulosFamiliasBC bc;

	@Override
	protected List<ArticulosFamilias> handleResultList() {
		// TODO Auto-generated method stub
		return bc.findAll();
	}

}
