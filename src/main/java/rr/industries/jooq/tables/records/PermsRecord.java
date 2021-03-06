/*
 * This file is generated by jOOQ.
*/
package rr.industries.jooq.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;

import rr.industries.jooq.tables.Perms;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PermsRecord extends TableRecordImpl<PermsRecord> implements Record3<Long, Long, Integer> {

    private static final long serialVersionUID = 787251145;

    /**
     * Setter for <code>perms.guildid</code>.
     */
    public void setGuildid(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>perms.guildid</code>.
     */
    public Long getGuildid() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>perms.userid</code>.
     */
    public void setUserid(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>perms.userid</code>.
     */
    public Long getUserid() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>perms.perm</code>.
     */
    public void setPerm(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>perms.perm</code>.
     */
    public Integer getPerm() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Perms.PERMS.GUILDID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return Perms.PERMS.USERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Perms.PERMS.PERM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getGuildid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getPerm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getGuildid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getPerm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PermsRecord value1(Long value) {
        setGuildid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PermsRecord value2(Long value) {
        setUserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PermsRecord value3(Integer value) {
        setPerm(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PermsRecord values(Long value1, Long value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PermsRecord
     */
    public PermsRecord() {
        super(Perms.PERMS);
    }

    /**
     * Create a detached, initialised PermsRecord
     */
    public PermsRecord(Long guildid, Long userid, Integer perm) {
        super(Perms.PERMS);

        set(0, guildid);
        set(1, userid);
        set(2, perm);
    }
}
