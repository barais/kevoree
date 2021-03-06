/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.kevoree.kompare.tests.components

import org.junit._
import org.kevoree.api.service.core.kompare.ModelKompareService
import org.kevoree.kompare._
import org.kevoreeAdaptation._
import org.scalatest.junit.AssertionsForJUnit
import org.kevoree.kompare.tests._

class ComponentsTest extends AssertionsForJUnit with KompareSuite {

  var component : ModelKompareService = null

  @Before def initialize() {
    component = new KevoreeKompareBean
  }

  @Test def verifyComponentTypeAdded() {
    //var kompareModel = component.kompare(model("test_ports/MinusProvidedMessagePort.art2"), model("test_ports/base.art2"), "nodeA")
   // error("NOT IMPLEMENTED YET");
  }

  @Test def verifyComponentTypeRemoved() {
    //var kompareModel = component.kompare(model("test_ports/MinusProvidedMessagePort.art2"), model("test_ports/base.art2"), "nodeA")
   // error("NOT IMPLEMENTED YET");
  }

  @Test def verifyComponentTypeRenamed() {
    //var kompareModel = component.kompare(model("test_ports/MinusProvidedMessagePort.art2"), model("test_ports/base.art2"), "nodeA")
   // error("NOT IMPLEMENTED YET");
  }

}
