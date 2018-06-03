package com.datarepublic.simplecab.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cab_trip_data_cache", schema = "cab", catalog = "")
public class CabTripDataCacheEntity implements Serializable {
	private long id;
	private Integer tripCount;

	@Id
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "trip_count")
	public Integer getTripCount() {
		return tripCount;
	}

	public void setTripCount(Integer tripCount) {
		this.tripCount = tripCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CabTripDataCacheEntity that = (CabTripDataCacheEntity) o;
		return id == that.id &&
				Objects.equals(tripCount, that.tripCount);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, tripCount);
	}
}
