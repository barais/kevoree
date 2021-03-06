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

package org.kevoree.framework.aspects

import org.kevoree._
import scala.collection.JavaConversions._
import KevoreeAspects._

case class ContainerNodeAspect(node : ContainerNode) {

  def isModelEquals(ct : ContainerNode) : Boolean = {
    ct.getName == node.getName
    /* TODO deep compare */
  }

  def getComponentTypes : List[ComponentType] = {
    var alreadyDeployComponentType : List[ComponentType] = List()
    node.getComponents.foreach{c=>
      if(!alreadyDeployComponentType.exists({e=> e.getName == c.getTypeDefinition.getName})){
        alreadyDeployComponentType = alreadyDeployComponentType ++ List(c.getTypeDefinition.asInstanceOf[ComponentType])
      }
    }
    alreadyDeployComponentType
  }
  
  def getUsedTypeDefinition : List[TypeDefinition] = {
    var usedType : List[TypeDefinition] = List()
    
    /* ADD COMPONENT TYPE USED */
    node.getComponents.foreach{c=>
      if(!usedType.exists({e=> e.getName == c.getTypeDefinition.getName})){
        usedType = usedType ++ List(c.getTypeDefinition)
      }
    } 
    
    /* ADD CHANNEL TYPE USED */
    /* add channel fragment on node */
    node.eContainer.asInstanceOf[ContainerRoot].getMBindings.foreach{mb =>
      if(mb.getPort.eContainer.eContainer == node){
        if(!usedType.exists({e=> e.getName == mb.getHub.getTypeDefinition.getName})){
          usedType = usedType ++ List(mb.getHub.getTypeDefinition)
        }
      }
    }
    
    usedType
  }
  
  def getChannelFragment : List[Channel] = {
    var usedChannel : List[Channel] = List()
    /* add channel fragment on node */
    node.eContainer.asInstanceOf[ContainerRoot].getMBindings.foreach{mb =>
      if(mb.getPort.eContainer.eContainer == node){
        if(!usedChannel.exists({e=> e.getName == mb.getHub.getName})){
          usedChannel = usedChannel ++ List(mb.getHub)
        }
      }
    }
    usedChannel
  }

  def getInstances : List[Instance] = getChannelFragment ++ node.getComponents




}
