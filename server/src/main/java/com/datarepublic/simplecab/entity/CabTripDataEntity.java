package com.datarepublic.simplecab.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cab_trip_data", schema = "cab", catalog = "")
public class CabTripDataEntity {
	private String medallion;
	private String hackLicense;
	private String vendorId;
	private Integer rateCode;
	private String storeAndFwdFlag;
	private Timestamp pickupDatetime;
	private Timestamp dropoffDatetime;
	private Integer passengerCount;
	private Integer tripTimeInSecs;
	private Double tripDistance;
	private Double pickupLongitude;
	private Double pickupLatitude;
	private Double dropoffLongitude;
	private Double dropoffLatitude;
	private int id;

	@Basic
	@Column(name = "medallion")
	public String getMedallion() {
		return medallion;
	}

	public void setMedallion(String medallion) {
		this.medallion = medallion;
	}

	@Basic
	@Column(name = "hack_license")
	public String getHackLicense() {
		return hackLicense;
	}

	public void setHackLicense(String hackLicense) {
		this.hackLicense = hackLicense;
	}

	@Basic
	@Column(name = "vendor_id")
	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	@Basic
	@Column(name = "rate_code")
	public Integer getRateCode() {
		return rateCode;
	}

	public void setRateCode(Integer rateCode) {
		this.rateCode = rateCode;
	}

	@Basic
	@Column(name = "store_and_fwd_flag")
	public String getStoreAndFwdFlag() {
		return storeAndFwdFlag;
	}

	public void setStoreAndFwdFlag(String storeAndFwdFlag) {
		this.storeAndFwdFlag = storeAndFwdFlag;
	}

	@Basic
	@Column(name = "pickup_datetime")
	public Timestamp getPickupDatetime() {
		return pickupDatetime;
	}

	public void setPickupDatetime(Timestamp pickupDatetime) {
		this.pickupDatetime = pickupDatetime;
	}

	@Basic
	@Column(name = "dropoff_datetime")
	public Timestamp getDropoffDatetime() {
		return dropoffDatetime;
	}

	public void setDropoffDatetime(Timestamp dropoffDatetime) {
		this.dropoffDatetime = dropoffDatetime;
	}

	@Basic
	@Column(name = "passenger_count")
	public Integer getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}

	@Basic
	@Column(name = "trip_time_in_secs")
	public Integer getTripTimeInSecs() {
		return tripTimeInSecs;
	}

	public void setTripTimeInSecs(Integer tripTimeInSecs) {
		this.tripTimeInSecs = tripTimeInSecs;
	}

	@Basic
	@Column(name = "trip_distance")
	public Double getTripDistance() {
		return tripDistance;
	}

	public void setTripDistance(Double tripDistance) {
		this.tripDistance = tripDistance;
	}

	@Basic
	@Column(name = "pickup_longitude")
	public Double getPickupLongitude() {
		return pickupLongitude;
	}

	public void setPickupLongitude(Double pickupLongitude) {
		this.pickupLongitude = pickupLongitude;
	}

	@Basic
	@Column(name = "pickup_latitude")
	public Double getPickupLatitude() {
		return pickupLatitude;
	}

	public void setPickupLatitude(Double pickupLatitude) {
		this.pickupLatitude = pickupLatitude;
	}

	@Basic
	@Column(name = "dropoff_longitude")
	public Double getDropoffLongitude() {
		return dropoffLongitude;
	}

	public void setDropoffLongitude(Double dropoffLongitude) {
		this.dropoffLongitude = dropoffLongitude;
	}

	@Basic
	@Column(name = "dropoff_latitude")
	public Double getDropoffLatitude() {
		return dropoffLatitude;
	}

	public void setDropoffLatitude(Double dropoffLatitude) {
		this.dropoffLatitude = dropoffLatitude;
	}

	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CabTripDataEntity that = (CabTripDataEntity) o;
		return id == that.id &&
				Objects.equals(medallion, that.medallion) &&
				Objects.equals(hackLicense, that.hackLicense) &&
				Objects.equals(vendorId, that.vendorId) &&
				Objects.equals(rateCode, that.rateCode) &&
				Objects.equals(storeAndFwdFlag, that.storeAndFwdFlag) &&
				Objects.equals(pickupDatetime, that.pickupDatetime) &&
				Objects.equals(dropoffDatetime, that.dropoffDatetime) &&
				Objects.equals(passengerCount, that.passengerCount) &&
				Objects.equals(tripTimeInSecs, that.tripTimeInSecs) &&
				Objects.equals(tripDistance, that.tripDistance) &&
				Objects.equals(pickupLongitude, that.pickupLongitude) &&
				Objects.equals(pickupLatitude, that.pickupLatitude) &&
				Objects.equals(dropoffLongitude, that.dropoffLongitude) &&
				Objects.equals(dropoffLatitude, that.dropoffLatitude);
	}

	@Override
	public int hashCode() {

		return Objects.hash(medallion, hackLicense, vendorId, rateCode, storeAndFwdFlag, pickupDatetime, dropoffDatetime, passengerCount, tripTimeInSecs, tripDistance, pickupLongitude, pickupLatitude, dropoffLongitude, dropoffLatitude, id);
	}
}
