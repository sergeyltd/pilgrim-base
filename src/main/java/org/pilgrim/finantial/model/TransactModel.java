package org.pilgrim.finantial.model;

import java.math.BigDecimal;
import java.util.Date;

import org.pilgrim.finantial.GsonHelper;

public class TransactModel {
    private Date transactionDate;
    private Date postedDate;
    private String cardInfo;
    private String description;
    private String category;
    private BigDecimal debit = BigDecimal.ZERO;
    private BigDecimal credit = BigDecimal.ZERO;
    private String bankName;
    
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(String cardInfo) {
        this.cardInfo = cardInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cardInfo == null) ? 0 : cardInfo.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((credit == null) ? 0 : credit.hashCode());
        result = prime * result + ((debit == null) ? 0 : debit.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((postedDate == null) ? 0 : postedDate.hashCode());
        result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TransactModel)) {
            return false;
        }
        TransactModel other = (TransactModel) obj;
        if (cardInfo == null) {
            if (other.cardInfo != null) {
                return false;
            }
        } else if (!cardInfo.equals(other.cardInfo)) {
            return false;
        }
        if (category == null) {
            if (other.category != null) {
                return false;
            }
        } else if (!category.equals(other.category)) {
            return false;
        }
        if (credit == null) {
            if (other.credit != null) {
                return false;
            }
        } else if (!credit.equals(other.credit)) {
            return false;
        }
        if (debit == null) {
            if (other.debit != null) {
                return false;
            }
        } else if (!debit.equals(other.debit)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (postedDate == null) {
            if (other.postedDate != null) {
                return false;
            }
        } else if (!postedDate.equals(other.postedDate)) {
            return false;
        }
        if (transactionDate == null) {
            if (other.transactionDate != null) {
                return false;
            }
        } else if (!transactionDate.equals(other.transactionDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        // StringBuilder builder = new StringBuilder();
        // builder.append("TransactModel [transactionDate=");
        // builder.append(transactionDate);
        // builder.append(", postedDate=");
        // builder.append(postedDate);
        // builder.append(", cardInfo=");
        // builder.append(cardInfo);
        // builder.append(", description=");
        // builder.append(description);
        // builder.append(", category=");
        // builder.append(category);
        // builder.append(", debit=");
        // builder.append(debit);
        // builder.append(", credit=");
        // builder.append(credit);
        // builder.append("]");
        // return builder.toString();
        return GsonHelper.toJson(this);
    }
}
