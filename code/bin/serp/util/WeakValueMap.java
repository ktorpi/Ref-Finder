/* 
*    Ref-Finder
*    Copyright (C) <2015>  <PLSE_UCLA>
*
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package serp.util;

import java.lang.ref.ReferenceQueue;
import java.util.Map;

public class WeakValueMap
  extends RefValueMap
{
  public WeakValueMap() {}
  
  public WeakValueMap(Map map)
  {
    super(map);
  }
  
  protected RefValueMap.RefMapValue createRefMapValue(Object key, Object value, ReferenceQueue queue)
  {
    return new WeakValueMap.WeakMapValue(key, value, queue);
  }
}
