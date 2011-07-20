/* 
 * Sourcerer: an infrastructure for large-scale source code analysis.
 * Copyright (C) by contributors. See CONTRIBUTORS.txt for full list.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package edu.uci.ics.sourcerer.utils.db.internal;

import edu.uci.ics.sourcerer.utils.db.sql.IColumn;
import edu.uci.ics.sourcerer.utils.db.sql.IComparisonCondition;
import edu.uci.ics.sourcerer.utils.db.sql.ITable;

/**
 * @author Joel Ossher (jossher@uci.edu)
 */
class ComparisonCondition implements IComparisonCondition {
  private IColumn<?> left;
  private IColumn<?> right;
  <T> ComparisonCondition(IColumn<T> left, IColumn<T> right) {
    this.left = left;
    this.right = right;
  }
  
  @Override
  public ITable getLeftTable() {
    return left.getTable();
  }


  @Override
  public ITable getRightTable() {
    return right.getTable();
  }
  
  @Override
  public String toSql() {
    return left.toSql() + "=" + right.toSql();
  }
}
