// Copyright 2016 The Domain Registry Authors. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package google.registry.tools;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import google.registry.model.domain.DomainResource;
import google.registry.tools.Command.GtechCommand;

import java.util.List;

/** Command to show a domain resource. */
@Parameters(separators = " =", commandDescription = "Show domain record(s)")
final class GetDomainCommand extends GetEppResourceCommand<DomainResource>
    implements GtechCommand {

  @Parameter(
      description = "Fully qualified domain name(s)",
      required = true)
  private List<String> mainParameters;

  @Override
  public void processParameters() {
    for (String domainName : mainParameters) {
      printResource(domainName);
    }
  }
}