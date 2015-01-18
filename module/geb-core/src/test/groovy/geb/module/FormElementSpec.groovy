/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package geb.module

import geb.test.CrossBrowser
import geb.test.GebSpecWithServer

@CrossBrowser
class FormElementSpec extends GebSpecWithServer {

	def disabled() {
		given:
		html {
			input(id: "noDisabledAttr")
			input(id: "disabledAttr", disabled: 'disabled')
			input(id: "disabledAttr2", disabled: 'xyz')
		}

		expect:
		$("#noDisabledAttr").module(FormElement).enabled
		!$("#noDisabledAttr").module(FormElement).disabled
		$("#disabledAttr").module(FormElement).disabled
		!$("#disabledAttr").module(FormElement).enabled
		$("#disabledAttr2").module(FormElement).disabled
		!$("#disabledAttr2").module(FormElement).enabled
	}

	def readOnly() {
		given:
		html {
			input(id: "noReadonlyAttr")
			input(id: "readonlyAttr", readonly: 'readonly')
			input(id: "readonlyAttr2", readonly: 'xyz')
		}

		expect:
		$("#noReadonlyAttr").module(FormElement).editable
		!$("#noReadonlyAttr").module(FormElement).readOnly
		$("#readonlyAttr").module(FormElement).readOnly
		!$("#readonlyAttr").module(FormElement).editable
		$("#readonlyAttr2").module(FormElement).readOnly
		!$("#readonlyAttr2").module(FormElement).editable
	}
}
