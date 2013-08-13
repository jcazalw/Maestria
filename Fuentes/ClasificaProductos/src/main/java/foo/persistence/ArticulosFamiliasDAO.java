package foo.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;

import foo.domain.ArticulosFamilias;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class ArticulosFamiliasDAO extends JPACrud<ArticulosFamilias, Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;
	
	public List<ArticulosFamilias>getFamiliaByNivel(Integer nivelId){
		 Query query = getEntityManager().createNamedQuery("ArticulosFamilias.findByNivelId").setParameter("nivelId", nivelId);
		 return query.getResultList();		
	}

}
