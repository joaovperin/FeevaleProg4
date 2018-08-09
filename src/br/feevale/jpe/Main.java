/*
 * Copyright (C) 2018 Perin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.feevale.jpe;

import br.feevale.jpe.core.SimpleApplication;
import br.feevale.jpe.core.ApplicationException;

/**
 * Main class
 *
 * @author joaovperin
 */
public class Main {

    /**
     * Main entry point
     *
     * @param args the command line arguments
     * @throws br.feevale.jpe.core.ApplicationException
     */
    public static void main(String[] args) throws ApplicationException {
        new SimpleApplication().config(args).run();
    }

}
