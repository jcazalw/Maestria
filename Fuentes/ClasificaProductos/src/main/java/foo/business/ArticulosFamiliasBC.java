package foo.business;

import foo.domain.ArticulosFamilias;
import foo.persistence.ArticulosFamiliasDAO;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class ArticulosFamiliasBC extends DelegateCrud<ArticulosFamilias, Integer, ArticulosFamiliasDAO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			
		}
	}	

}
