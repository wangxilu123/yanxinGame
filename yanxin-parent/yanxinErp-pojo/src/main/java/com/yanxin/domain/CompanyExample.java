package com.yanxin.domain;

import java.util.ArrayList;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNull() {
            addCriterion("company_address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("company_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("company_address =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("company_address <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("company_address >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("company_address >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("company_address <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("company_address <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("company_address like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("company_address not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("company_address in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("company_address not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("company_address between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("company_address not between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveIsNull() {
            addCriterion("id_cardPositive is null");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveIsNotNull() {
            addCriterion("id_cardPositive is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveEqualTo(String value) {
            addCriterion("id_cardPositive =", value, "idCardpositive");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveNotEqualTo(String value) {
            addCriterion("id_cardPositive <>", value, "idCardpositive");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveGreaterThan(String value) {
            addCriterion("id_cardPositive >", value, "idCardpositive");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveGreaterThanOrEqualTo(String value) {
            addCriterion("id_cardPositive >=", value, "idCardpositive");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveLessThan(String value) {
            addCriterion("id_cardPositive <", value, "idCardpositive");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveLessThanOrEqualTo(String value) {
            addCriterion("id_cardPositive <=", value, "idCardpositive");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveLike(String value) {
            addCriterion("id_cardPositive like", value, "idCardpositive");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveNotLike(String value) {
            addCriterion("id_cardPositive not like", value, "idCardpositive");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveIn(List<String> values) {
            addCriterion("id_cardPositive in", values, "idCardpositive");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveNotIn(List<String> values) {
            addCriterion("id_cardPositive not in", values, "idCardpositive");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveBetween(String value1, String value2) {
            addCriterion("id_cardPositive between", value1, value2, "idCardpositive");
            return (Criteria) this;
        }

        public Criteria andIdCardpositiveNotBetween(String value1, String value2) {
            addCriterion("id_cardPositive not between", value1, value2, "idCardpositive");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideIsNull() {
            addCriterion("id_cardOtherside is null");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideIsNotNull() {
            addCriterion("id_cardOtherside is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideEqualTo(String value) {
            addCriterion("id_cardOtherside =", value, "idCardotherside");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideNotEqualTo(String value) {
            addCriterion("id_cardOtherside <>", value, "idCardotherside");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideGreaterThan(String value) {
            addCriterion("id_cardOtherside >", value, "idCardotherside");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideGreaterThanOrEqualTo(String value) {
            addCriterion("id_cardOtherside >=", value, "idCardotherside");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideLessThan(String value) {
            addCriterion("id_cardOtherside <", value, "idCardotherside");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideLessThanOrEqualTo(String value) {
            addCriterion("id_cardOtherside <=", value, "idCardotherside");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideLike(String value) {
            addCriterion("id_cardOtherside like", value, "idCardotherside");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideNotLike(String value) {
            addCriterion("id_cardOtherside not like", value, "idCardotherside");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideIn(List<String> values) {
            addCriterion("id_cardOtherside in", values, "idCardotherside");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideNotIn(List<String> values) {
            addCriterion("id_cardOtherside not in", values, "idCardotherside");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideBetween(String value1, String value2) {
            addCriterion("id_cardOtherside between", value1, value2, "idCardotherside");
            return (Criteria) this;
        }

        public Criteria andIdCardothersideNotBetween(String value1, String value2) {
            addCriterion("id_cardOtherside not between", value1, value2, "idCardotherside");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountIsNull() {
            addCriterion("weixin_payAccount is null");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountIsNotNull() {
            addCriterion("weixin_payAccount is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountEqualTo(String value) {
            addCriterion("weixin_payAccount =", value, "weixinPayaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountNotEqualTo(String value) {
            addCriterion("weixin_payAccount <>", value, "weixinPayaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountGreaterThan(String value) {
            addCriterion("weixin_payAccount >", value, "weixinPayaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_payAccount >=", value, "weixinPayaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountLessThan(String value) {
            addCriterion("weixin_payAccount <", value, "weixinPayaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountLessThanOrEqualTo(String value) {
            addCriterion("weixin_payAccount <=", value, "weixinPayaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountLike(String value) {
            addCriterion("weixin_payAccount like", value, "weixinPayaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountNotLike(String value) {
            addCriterion("weixin_payAccount not like", value, "weixinPayaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountIn(List<String> values) {
            addCriterion("weixin_payAccount in", values, "weixinPayaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountNotIn(List<String> values) {
            addCriterion("weixin_payAccount not in", values, "weixinPayaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountBetween(String value1, String value2) {
            addCriterion("weixin_payAccount between", value1, value2, "weixinPayaccount");
            return (Criteria) this;
        }

        public Criteria andWeixinPayaccountNotBetween(String value1, String value2) {
            addCriterion("weixin_payAccount not between", value1, value2, "weixinPayaccount");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountIsNull() {
            addCriterion("ali_payAccount is null");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountIsNotNull() {
            addCriterion("ali_payAccount is not null");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountEqualTo(String value) {
            addCriterion("ali_payAccount =", value, "aliPayaccount");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountNotEqualTo(String value) {
            addCriterion("ali_payAccount <>", value, "aliPayaccount");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountGreaterThan(String value) {
            addCriterion("ali_payAccount >", value, "aliPayaccount");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountGreaterThanOrEqualTo(String value) {
            addCriterion("ali_payAccount >=", value, "aliPayaccount");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountLessThan(String value) {
            addCriterion("ali_payAccount <", value, "aliPayaccount");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountLessThanOrEqualTo(String value) {
            addCriterion("ali_payAccount <=", value, "aliPayaccount");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountLike(String value) {
            addCriterion("ali_payAccount like", value, "aliPayaccount");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountNotLike(String value) {
            addCriterion("ali_payAccount not like", value, "aliPayaccount");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountIn(List<String> values) {
            addCriterion("ali_payAccount in", values, "aliPayaccount");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountNotIn(List<String> values) {
            addCriterion("ali_payAccount not in", values, "aliPayaccount");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountBetween(String value1, String value2) {
            addCriterion("ali_payAccount between", value1, value2, "aliPayaccount");
            return (Criteria) this;
        }

        public Criteria andAliPayaccountNotBetween(String value1, String value2) {
            addCriterion("ali_payAccount not between", value1, value2, "aliPayaccount");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}