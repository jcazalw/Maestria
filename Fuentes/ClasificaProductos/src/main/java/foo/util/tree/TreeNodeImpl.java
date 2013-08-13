package foo.util.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

public class TreeNodeImpl implements TreeNode, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String DEFAULT_TYPE = "default";
	
	private String type;
	
	private Object data;
	
	private Integer id;
	
	private List<TreeNode> children;
	
	private TreeNode parent;
	
	private boolean expanded;

    private boolean selected;
    
    private boolean selectable = true;
	
	public TreeNodeImpl() {
        this.type = DEFAULT_TYPE;
        children = new ArrayList<TreeNode>();
    }

	public TreeNodeImpl(Object data, TreeNode parent) {
		this.type = DEFAULT_TYPE;
		this.data = data;
		children = new ArrayList<TreeNode>();
		this.parent = parent;
		if(this.parent != null)
			this.parent.getChildren().add(this);
	}
	
	public TreeNodeImpl(String type, Object data, TreeNode parent) {
		this.type = type;
		this.data = data;
		children = new ArrayList<TreeNode>();
		this.parent = parent;
		if(this.parent != null)
			this.parent.getChildren().add(this);
	}
	
	public TreeNodeImpl(String type, Integer id, TreeNode parent) {
		this.type = type;
		this.id = id;
		
		children = new ArrayList<TreeNode>();
		this.parent = parent;
		if(this.parent != null)
			this.parent.getChildren().add(this);
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public List<TreeNode> getChildren() {
		return children;
	}
	
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
	public TreeNode getParent() {
		return parent;
	}
	
	public void setParent(TreeNode parent) {
        if(this.parent != null) {
            this.parent.getChildren().remove(this);
        }
        
        this.parent = parent;
        
        if(this.parent != null) {
            this.parent.getChildren().add(this);
        }
	}
	
	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean value) {
        this.selected = value;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }
    
	public int getChildCount() {
		return children.size();
	}
	
	public boolean isLeaf() {
		if(children == null)
			return true;
		
		return children.isEmpty();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		
		TreeNodeImpl other = (TreeNodeImpl) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		if(data != null)
			return data.toString();
		else
			return super.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
}