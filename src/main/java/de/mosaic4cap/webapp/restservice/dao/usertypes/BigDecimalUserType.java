package de.mosaic4cap.webapp.restservice.dao.usertypes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.annotations.TypeDef;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

/**
 * This software is public domain and carries NO WARRANTY.
 * <p>
 * Patches, bug reports and feature requests welcome:
 * <p>
 * https://bitbucket.org/ratkins/bigdecimalusertype/
 */
@TypeDef(defaultForType = BigDecimal.class, typeClass = BigDecimalUserType.class)
public class BigDecimalUserType implements UserType {

  private static final int[] SQL_TYPES = new int[]{ Types.DECIMAL, Types.INTEGER };

  @Override
  public Object assemble(Serializable arg0, Object arg1) throws HibernateException {
    return deepCopy(arg0);
  }

  @Override
  public Object deepCopy(Object arg0) throws HibernateException {
    return arg0;
  }

  @Override
  public Serializable disassemble(Object arg0) throws HibernateException {
    return (Serializable) arg0;
  }

  @Override
  public boolean equals(Object arg0, Object arg1) throws HibernateException {
    return arg0.equals(arg1);
  }

  @Override
  public int hashCode(Object arg0) throws HibernateException {
    return arg0.hashCode();
  }

  @Override
  public boolean isMutable() {
    return false;
  }

  @Override
  public Object nullSafeGet(ResultSet aResultSet,
                            String[] aStrings,
                            SessionImplementor aSessionImplementor,
                            Object o) throws HibernateException, SQLException {
    BigDecimal bigDecimal = aResultSet.getBigDecimal(aStrings[0]);
    if (bigDecimal == null) {
      return null;
    }
    return bigDecimal.setScale(aResultSet.getInt(aStrings[1]), BigDecimal.ROUND_HALF_UP);
  }

  @Override
  public void nullSafeSet(PreparedStatement aPreparedStatement,
                          Object o,
                          int i,
                          SessionImplementor aSessionImplementor) throws HibernateException, SQLException {
    if (o == null) {
      aPreparedStatement.setNull(i, Types.DECIMAL);
      aPreparedStatement.setNull(i + 1, Types.INTEGER);
    } else {
      aPreparedStatement.setBigDecimal(i, (BigDecimal) o);
      aPreparedStatement.setInt(i + 1, ((BigDecimal) o).scale());
    }
  }

  @Override
  public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {
    return arg0;
  }

  @Override
  public Class<?> returnedClass() {
    return BigDecimal.class;
  }

  @Override
  public int[] sqlTypes() {
    return SQL_TYPES;
  }
}
