package de.mosaic4cap.webapp.stereotypes.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 29.08.14.
 * Superclass for all entities holding id, equals and hashcode
 */
@MappedSuperclass
public abstract class AbstractMosaic4CapEntity implements Serializable {
	private static final Logger LOGGER = Logger.getLogger(AbstractMosaic4CapEntity.class);

	@Id
	@GeneratedValue
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long aId) {
		this.id = aId;
	}

	@JsonIgnore
	public Object getBusinessKey() {
		return getId();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		AbstractMosaic4CapEntity that = (AbstractMosaic4CapEntity) o;

		if (getBusinessKey() != null ? !getBusinessKey().equals(that.getBusinessKey()) : that.getBusinessKey() != null) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		if (getBusinessKey() == null) {
			return 0;
		} else {
			return getBusinessKey().hashCode();
		}
	}

	@Override
	public String toString() {
		return "AbstractMosaicEntity{" +
					 "id=" + id +
					 '}';
	}
}
