package com.msb.entity;

/**
 * Created by 17081290 on 2021/3/19.
 */
public class Address {
    private String province;
    private String city;
    private String town;

    public Address(String province, String town, String city) {
        this.province = province;
        this.town = town;
        this.city = city;
    }


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                '}';
    }
}
