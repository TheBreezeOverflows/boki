package boke.boke.entity;

import java.util.ArrayList;
import java.util.List;

public class ClassifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassifyExample() {
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

        public Criteria andClassifyIdIsNull() {
            addCriterion("Classify_id is null");
            return (Criteria) this;
        }

        public Criteria andClassifyIdIsNotNull() {
            addCriterion("Classify_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyIdEqualTo(Integer value) {
            addCriterion("Classify_id =", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotEqualTo(Integer value) {
            addCriterion("Classify_id <>", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdGreaterThan(Integer value) {
            addCriterion("Classify_id >", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Classify_id >=", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdLessThan(Integer value) {
            addCriterion("Classify_id <", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdLessThanOrEqualTo(Integer value) {
            addCriterion("Classify_id <=", value, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdIn(List<Integer> values) {
            addCriterion("Classify_id in", values, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotIn(List<Integer> values) {
            addCriterion("Classify_id not in", values, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdBetween(Integer value1, Integer value2) {
            addCriterion("Classify_id between", value1, value2, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Classify_id not between", value1, value2, "classifyId");
            return (Criteria) this;
        }

        public Criteria andClassifyNameIsNull() {
            addCriterion("Classify_Name is null");
            return (Criteria) this;
        }

        public Criteria andClassifyNameIsNotNull() {
            addCriterion("Classify_Name is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyNameEqualTo(String value) {
            addCriterion("Classify_Name =", value, "classifyName");
            return (Criteria) this;
        }

        public Criteria andClassifyNameNotEqualTo(String value) {
            addCriterion("Classify_Name <>", value, "classifyName");
            return (Criteria) this;
        }

        public Criteria andClassifyNameGreaterThan(String value) {
            addCriterion("Classify_Name >", value, "classifyName");
            return (Criteria) this;
        }

        public Criteria andClassifyNameGreaterThanOrEqualTo(String value) {
            addCriterion("Classify_Name >=", value, "classifyName");
            return (Criteria) this;
        }

        public Criteria andClassifyNameLessThan(String value) {
            addCriterion("Classify_Name <", value, "classifyName");
            return (Criteria) this;
        }

        public Criteria andClassifyNameLessThanOrEqualTo(String value) {
            addCriterion("Classify_Name <=", value, "classifyName");
            return (Criteria) this;
        }

        public Criteria andClassifyNameLike(String value) {
            addCriterion("Classify_Name like", value, "classifyName");
            return (Criteria) this;
        }

        public Criteria andClassifyNameNotLike(String value) {
            addCriterion("Classify_Name not like", value, "classifyName");
            return (Criteria) this;
        }

        public Criteria andClassifyNameIn(List<String> values) {
            addCriterion("Classify_Name in", values, "classifyName");
            return (Criteria) this;
        }

        public Criteria andClassifyNameNotIn(List<String> values) {
            addCriterion("Classify_Name not in", values, "classifyName");
            return (Criteria) this;
        }

        public Criteria andClassifyNameBetween(String value1, String value2) {
            addCriterion("Classify_Name between", value1, value2, "classifyName");
            return (Criteria) this;
        }

        public Criteria andClassifyNameNotBetween(String value1, String value2) {
            addCriterion("Classify_Name not between", value1, value2, "classifyName");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryIsNull() {
            addCriterion("Classify_Category is null");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryIsNotNull() {
            addCriterion("Classify_Category is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryEqualTo(String value) {
            addCriterion("Classify_Category =", value, "classifyCategory");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryNotEqualTo(String value) {
            addCriterion("Classify_Category <>", value, "classifyCategory");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryGreaterThan(String value) {
            addCriterion("Classify_Category >", value, "classifyCategory");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("Classify_Category >=", value, "classifyCategory");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryLessThan(String value) {
            addCriterion("Classify_Category <", value, "classifyCategory");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryLessThanOrEqualTo(String value) {
            addCriterion("Classify_Category <=", value, "classifyCategory");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryLike(String value) {
            addCriterion("Classify_Category like", value, "classifyCategory");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryNotLike(String value) {
            addCriterion("Classify_Category not like", value, "classifyCategory");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryIn(List<String> values) {
            addCriterion("Classify_Category in", values, "classifyCategory");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryNotIn(List<String> values) {
            addCriterion("Classify_Category not in", values, "classifyCategory");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryBetween(String value1, String value2) {
            addCriterion("Classify_Category between", value1, value2, "classifyCategory");
            return (Criteria) this;
        }

        public Criteria andClassifyCategoryNotBetween(String value1, String value2) {
            addCriterion("Classify_Category not between", value1, value2, "classifyCategory");
            return (Criteria) this;
        }

        public Criteria andSuperclassIdIsNull() {
            addCriterion("Superclass_id is null");
            return (Criteria) this;
        }

        public Criteria andSuperclassIdIsNotNull() {
            addCriterion("Superclass_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuperclassIdEqualTo(Integer value) {
            addCriterion("Superclass_id =", value, "superclassId");
            return (Criteria) this;
        }

        public Criteria andSuperclassIdNotEqualTo(Integer value) {
            addCriterion("Superclass_id <>", value, "superclassId");
            return (Criteria) this;
        }

        public Criteria andSuperclassIdGreaterThan(Integer value) {
            addCriterion("Superclass_id >", value, "superclassId");
            return (Criteria) this;
        }

        public Criteria andSuperclassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Superclass_id >=", value, "superclassId");
            return (Criteria) this;
        }

        public Criteria andSuperclassIdLessThan(Integer value) {
            addCriterion("Superclass_id <", value, "superclassId");
            return (Criteria) this;
        }

        public Criteria andSuperclassIdLessThanOrEqualTo(Integer value) {
            addCriterion("Superclass_id <=", value, "superclassId");
            return (Criteria) this;
        }

        public Criteria andSuperclassIdIn(List<Integer> values) {
            addCriterion("Superclass_id in", values, "superclassId");
            return (Criteria) this;
        }

        public Criteria andSuperclassIdNotIn(List<Integer> values) {
            addCriterion("Superclass_id not in", values, "superclassId");
            return (Criteria) this;
        }

        public Criteria andSuperclassIdBetween(Integer value1, Integer value2) {
            addCriterion("Superclass_id between", value1, value2, "superclassId");
            return (Criteria) this;
        }

        public Criteria andSuperclassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Superclass_id not between", value1, value2, "superclassId");
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