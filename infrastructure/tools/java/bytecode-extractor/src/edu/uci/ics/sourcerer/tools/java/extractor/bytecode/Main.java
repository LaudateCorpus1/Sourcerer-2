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
package edu.uci.ics.sourcerer.tools.java.extractor.bytecode;

import java.io.File;

import edu.uci.ics.sourcerer.tools.java.model.extracted.io.WriterBundle;
import edu.uci.ics.sourcerer.util.io.FileUtils;
import edu.uci.ics.sourcerer.util.io.arguments.Command;

/**
 * @author Joel Ossher (jossher@uci.edu)
 */
public class Main {
  public static final Command EXTRACT_FILE = new Command("extract-file", "") {
    @Override
    protected void action() {
      ASMExtractor extractor = new ASMExtractor(new WriterBundle());
      extractor.extract(FileUtils.getFileAsByteArray(new File("/home/jossher/research/Sourcerer/Foo.class")));
      extractor.close();
    }
  };
  public static void main(String[] args) {
    //Command.execute(args, Main.class);
	String[] aux = {"--extract-file"};
	Command.execute(aux, Main.class);
  }
}
