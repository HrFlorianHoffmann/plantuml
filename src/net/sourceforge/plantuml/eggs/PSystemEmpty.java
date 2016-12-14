/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 * 
 *
 */
package net.sourceforge.plantuml.eggs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.plantuml.AbstractPSystem;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.core.DiagramDescription;
import net.sourceforge.plantuml.core.DiagramDescriptionImpl;
import net.sourceforge.plantuml.core.ImageData;
import net.sourceforge.plantuml.graphic.GraphicPosition;
import net.sourceforge.plantuml.graphic.GraphicStrings;
import net.sourceforge.plantuml.svek.TextBlockBackcolored;
import net.sourceforge.plantuml.ugraphic.ColorMapperIdentity;
import net.sourceforge.plantuml.ugraphic.ImageBuilder;
import net.sourceforge.plantuml.version.PSystemVersion;

public class PSystemEmpty extends AbstractPSystem {

	private final List<String> strings = new ArrayList<String>();

	public PSystemEmpty() {
		strings.add("<b>Welcome to PlantUML!");
		strings.add(" ");
		strings.add("If you use this software, you accept its license.");
		strings.add("(details by typing \"\"license\"\" keyword)");
		strings.add(" ");
		strings.add("You can start with a simple UML Diagram like:");
		strings.add(" ");
		strings.add("\"\"Bob->Alice: Hello\"\"");
		strings.add(" ");
		strings.add("Or");
		strings.add(" ");
		strings.add("\"\"class Example\"\"");
		strings.add(" ");
		strings.add("You will find more information about PlantUML syntax on <u>http://plantuml.com</u>");
		strings.add(" ");
		strings.add(" ");
		strings.add(" ");
		strings.add(" ");
	}

	@Override
	final protected ImageData exportDiagramNow(OutputStream os, int num, FileFormatOption fileFormat)
			throws IOException {
		final TextBlockBackcolored result = getGraphicStrings();
		final ImageBuilder imageBuilder = new ImageBuilder(new ColorMapperIdentity(), 1.0, result.getBackcolor(),
				getMetadata(), null, 0, 0, null, false);
		imageBuilder.setUDrawable(result);
		// imageBuilder.setUDrawable(TextBlockUtils.withMargin(result, 4, 4));
		return imageBuilder.writeImageTOBEMOVED(fileFormat, os);
	}

	private TextBlockBackcolored getGraphicStrings() throws IOException {
		final TextBlockBackcolored result = GraphicStrings.createBlackOnWhite(strings,
				PSystemVersion.getPlantumlImage(), GraphicPosition.BACKGROUND_CORNER_BOTTOM_RIGHT);
		return result;
	}

	public DiagramDescription getDescription() {
		return new DiagramDescriptionImpl("(Empty)", getClass());
	}

}