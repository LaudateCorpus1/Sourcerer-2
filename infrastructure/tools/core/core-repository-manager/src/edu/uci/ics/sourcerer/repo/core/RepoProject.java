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
package edu.uci.ics.sourcerer.repo.core;

import edu.uci.ics.sourcerer.util.io.arguments.Argument;
import edu.uci.ics.sourcerer.util.io.arguments.StringArgument;

/**
 * @author Joel Ossher (jossher@uci.edu)
 */
public class RepoProject {
  public static final Argument<String> PROJECT_PROPERTIES = new StringArgument("project-properties-file", "project.properties", "Properties files for a project.");
  
  protected final ProjectLocation loc;
  
  protected final RepoFile propFile;
  private ProjectProperties properties;
  
  protected RepoProject(ProjectLocation loc) {
    this.loc = loc;
    propFile = loc.getProjectRoot().getChild(PROJECT_PROPERTIES.getValue());
  }
  
  public final ProjectLocation getLocation() {
    return loc;
  }

  protected final RepoFile getProjectFile(Argument<String> arg) {
    return loc.getProjectRoot().getChild(arg.getValue());
  }
  
  public ProjectProperties getProperties() {
    if (properties == null) {
      properties = new ProjectProperties(propFile);
    }
    return properties;
  }
}
