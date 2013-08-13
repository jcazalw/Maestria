package foo.persistence;

import javax.inject.Inject;

import foo.domain.Condominio;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class CondominioDAO extends JPACrud<Condominio, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6272649458674142461L;	


}
