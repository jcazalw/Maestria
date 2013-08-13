package foo.view;

import java.util.List;

import foo.domain.Condominio;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;

@ViewController
public class CondominioListMB extends AbstractListPageBean<Condominio, Integer>{

	@Override
	protected List<Condominio> handleResultList() {
		// TODO Auto-generated method stub
		return null;
	}

}
