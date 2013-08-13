package foo.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;

import foo.domain.MigraProductos;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class MigraProductosDAO extends JPACrud<MigraProductos, Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;
	
	public List<MigraProductos> findNotCategorized(){
		 Query query = getEntityManager().createNamedQuery("MigraProductos.findNotArtiFamilia");
		 return query.getResultList();		
	}

}
