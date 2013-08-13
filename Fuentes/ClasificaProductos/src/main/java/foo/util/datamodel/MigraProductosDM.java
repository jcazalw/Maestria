package foo.util.datamodel;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import foo.domain.MigraProductos;

public class MigraProductosDM extends ListDataModel<MigraProductos> implements SelectableDataModel<MigraProductos> {

	@Override
	public Object getRowKey(MigraProductos object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MigraProductos getRowData(String rowKey) {
		// TODO Auto-generated method stub
		return null;
	}

}
