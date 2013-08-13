package foo.business;

import javax.inject.Inject;

import foo.domain.Condominio;
import foo.persistence.CondominioDAO;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class CondominioBC extends DelegateCrud<Condominio, Integer, CondominioDAO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MessageContext messageContext;

}
