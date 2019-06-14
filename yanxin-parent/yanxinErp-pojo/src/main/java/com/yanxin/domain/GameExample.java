package com.yanxin.domain;

import java.util.ArrayList;
import java.util.List;

public class GameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameExample() {
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

        public Criteria andGameNameIsNull() {
            addCriterion("game_name is null");
            return (Criteria) this;
        }

        public Criteria andGameNameIsNotNull() {
            addCriterion("game_name is not null");
            return (Criteria) this;
        }

        public Criteria andGameNameEqualTo(String value) {
            addCriterion("game_name =", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotEqualTo(String value) {
            addCriterion("game_name <>", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameGreaterThan(String value) {
            addCriterion("game_name >", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameGreaterThanOrEqualTo(String value) {
            addCriterion("game_name >=", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameLessThan(String value) {
            addCriterion("game_name <", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameLessThanOrEqualTo(String value) {
            addCriterion("game_name <=", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameLike(String value) {
            addCriterion("game_name like", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotLike(String value) {
            addCriterion("game_name not like", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameIn(List<String> values) {
            addCriterion("game_name in", values, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotIn(List<String> values) {
            addCriterion("game_name not in", values, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameBetween(String value1, String value2) {
            addCriterion("game_name between", value1, value2, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotBetween(String value1, String value2) {
            addCriterion("game_name not between", value1, value2, "gameName");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andIosPackageIsNull() {
            addCriterion("ios_package is null");
            return (Criteria) this;
        }

        public Criteria andIosPackageIsNotNull() {
            addCriterion("ios_package is not null");
            return (Criteria) this;
        }

        public Criteria andIosPackageEqualTo(String value) {
            addCriterion("ios_package =", value, "iosPackage");
            return (Criteria) this;
        }

        public Criteria andIosPackageNotEqualTo(String value) {
            addCriterion("ios_package <>", value, "iosPackage");
            return (Criteria) this;
        }

        public Criteria andIosPackageGreaterThan(String value) {
            addCriterion("ios_package >", value, "iosPackage");
            return (Criteria) this;
        }

        public Criteria andIosPackageGreaterThanOrEqualTo(String value) {
            addCriterion("ios_package >=", value, "iosPackage");
            return (Criteria) this;
        }

        public Criteria andIosPackageLessThan(String value) {
            addCriterion("ios_package <", value, "iosPackage");
            return (Criteria) this;
        }

        public Criteria andIosPackageLessThanOrEqualTo(String value) {
            addCriterion("ios_package <=", value, "iosPackage");
            return (Criteria) this;
        }

        public Criteria andIosPackageLike(String value) {
            addCriterion("ios_package like", value, "iosPackage");
            return (Criteria) this;
        }

        public Criteria andIosPackageNotLike(String value) {
            addCriterion("ios_package not like", value, "iosPackage");
            return (Criteria) this;
        }

        public Criteria andIosPackageIn(List<String> values) {
            addCriterion("ios_package in", values, "iosPackage");
            return (Criteria) this;
        }

        public Criteria andIosPackageNotIn(List<String> values) {
            addCriterion("ios_package not in", values, "iosPackage");
            return (Criteria) this;
        }

        public Criteria andIosPackageBetween(String value1, String value2) {
            addCriterion("ios_package between", value1, value2, "iosPackage");
            return (Criteria) this;
        }

        public Criteria andIosPackageNotBetween(String value1, String value2) {
            addCriterion("ios_package not between", value1, value2, "iosPackage");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageIsNull() {
            addCriterion("android_package is null");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageIsNotNull() {
            addCriterion("android_package is not null");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageEqualTo(String value) {
            addCriterion("android_package =", value, "androidPackage");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageNotEqualTo(String value) {
            addCriterion("android_package <>", value, "androidPackage");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageGreaterThan(String value) {
            addCriterion("android_package >", value, "androidPackage");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageGreaterThanOrEqualTo(String value) {
            addCriterion("android_package >=", value, "androidPackage");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageLessThan(String value) {
            addCriterion("android_package <", value, "androidPackage");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageLessThanOrEqualTo(String value) {
            addCriterion("android_package <=", value, "androidPackage");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageLike(String value) {
            addCriterion("android_package like", value, "androidPackage");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageNotLike(String value) {
            addCriterion("android_package not like", value, "androidPackage");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageIn(List<String> values) {
            addCriterion("android_package in", values, "androidPackage");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageNotIn(List<String> values) {
            addCriterion("android_package not in", values, "androidPackage");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageBetween(String value1, String value2) {
            addCriterion("android_package between", value1, value2, "androidPackage");
            return (Criteria) this;
        }

        public Criteria andAndroidPackageNotBetween(String value1, String value2) {
            addCriterion("android_package not between", value1, value2, "androidPackage");
            return (Criteria) this;
        }

        public Criteria andIosStatusIsNull() {
            addCriterion("ios_status is null");
            return (Criteria) this;
        }

        public Criteria andIosStatusIsNotNull() {
            addCriterion("ios_status is not null");
            return (Criteria) this;
        }

        public Criteria andIosStatusEqualTo(String value) {
            addCriterion("ios_status =", value, "iosStatus");
            return (Criteria) this;
        }

        public Criteria andIosStatusNotEqualTo(String value) {
            addCriterion("ios_status <>", value, "iosStatus");
            return (Criteria) this;
        }

        public Criteria andIosStatusGreaterThan(String value) {
            addCriterion("ios_status >", value, "iosStatus");
            return (Criteria) this;
        }

        public Criteria andIosStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ios_status >=", value, "iosStatus");
            return (Criteria) this;
        }

        public Criteria andIosStatusLessThan(String value) {
            addCriterion("ios_status <", value, "iosStatus");
            return (Criteria) this;
        }

        public Criteria andIosStatusLessThanOrEqualTo(String value) {
            addCriterion("ios_status <=", value, "iosStatus");
            return (Criteria) this;
        }

        public Criteria andIosStatusLike(String value) {
            addCriterion("ios_status like", value, "iosStatus");
            return (Criteria) this;
        }

        public Criteria andIosStatusNotLike(String value) {
            addCriterion("ios_status not like", value, "iosStatus");
            return (Criteria) this;
        }

        public Criteria andIosStatusIn(List<String> values) {
            addCriterion("ios_status in", values, "iosStatus");
            return (Criteria) this;
        }

        public Criteria andIosStatusNotIn(List<String> values) {
            addCriterion("ios_status not in", values, "iosStatus");
            return (Criteria) this;
        }

        public Criteria andIosStatusBetween(String value1, String value2) {
            addCriterion("ios_status between", value1, value2, "iosStatus");
            return (Criteria) this;
        }

        public Criteria andIosStatusNotBetween(String value1, String value2) {
            addCriterion("ios_status not between", value1, value2, "iosStatus");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusIsNull() {
            addCriterion("android_status is null");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusIsNotNull() {
            addCriterion("android_status is not null");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusEqualTo(String value) {
            addCriterion("android_status =", value, "androidStatus");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusNotEqualTo(String value) {
            addCriterion("android_status <>", value, "androidStatus");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusGreaterThan(String value) {
            addCriterion("android_status >", value, "androidStatus");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusGreaterThanOrEqualTo(String value) {
            addCriterion("android_status >=", value, "androidStatus");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusLessThan(String value) {
            addCriterion("android_status <", value, "androidStatus");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusLessThanOrEqualTo(String value) {
            addCriterion("android_status <=", value, "androidStatus");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusLike(String value) {
            addCriterion("android_status like", value, "androidStatus");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusNotLike(String value) {
            addCriterion("android_status not like", value, "androidStatus");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusIn(List<String> values) {
            addCriterion("android_status in", values, "androidStatus");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusNotIn(List<String> values) {
            addCriterion("android_status not in", values, "androidStatus");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusBetween(String value1, String value2) {
            addCriterion("android_status between", value1, value2, "androidStatus");
            return (Criteria) this;
        }

        public Criteria andAndroidStatusNotBetween(String value1, String value2) {
            addCriterion("android_status not between", value1, value2, "androidStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlIsNull() {
            addCriterion("download_url is null");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlIsNotNull() {
            addCriterion("download_url is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlEqualTo(String value) {
            addCriterion("download_url =", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotEqualTo(String value) {
            addCriterion("download_url <>", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlGreaterThan(String value) {
            addCriterion("download_url >", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("download_url >=", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLessThan(String value) {
            addCriterion("download_url <", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLessThanOrEqualTo(String value) {
            addCriterion("download_url <=", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlLike(String value) {
            addCriterion("download_url like", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotLike(String value) {
            addCriterion("download_url not like", value, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlIn(List<String> values) {
            addCriterion("download_url in", values, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotIn(List<String> values) {
            addCriterion("download_url not in", values, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlBetween(String value1, String value2) {
            addCriterion("download_url between", value1, value2, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andDownloadUrlNotBetween(String value1, String value2) {
            addCriterion("download_url not between", value1, value2, "downloadUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
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