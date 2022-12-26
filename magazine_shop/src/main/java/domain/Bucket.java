package domain;

import java.util.Date;

public class Bucket {

	private Integer id;
	private Integer userId;
	private Integer productId;
	private Date timeOperation;
	
	public Bucket(Integer id, Integer userId, Integer productId, Date timeOperation) {
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.timeOperation = timeOperation;
	}

	public Bucket(Integer userId, Integer productId, Date timeOperation) {
		this.userId = userId;
		this.productId = productId;
		this.timeOperation = timeOperation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Date getTimeOperation() {
		return timeOperation;
	}

	public void setTimeOperation(Date timeOperation) {
		this.timeOperation = timeOperation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((timeOperation == null) ? 0 : timeOperation.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (timeOperation == null) {
			if (other.timeOperation != null)
				return false;
		} else if (!timeOperation.equals(other.timeOperation))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", userId=" + userId + ", productId=" + productId + ", timeOperation="
				+ timeOperation + "]";
	}
	
}
