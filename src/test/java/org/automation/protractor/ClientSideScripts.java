package org.automation.protractor;

public class ClientSideScripts {

	public static final String GetNg1Hooks = "function getNg1Hooks(selector, injectorPlease) {\r\n"
			+ "  function tryEl(el) {\r\n" + "    try {\r\n"
			+ "      if (!injectorPlease && angular.getTestability) {\r\n"
			+ "        var $$testability = angular.getTestability(el);\r\n" + "        if ($$testability) {\r\n"
			+ "          return {$$testability: $$testability};\r\n" + "        }\r\n" + "      } else {\r\n"
			+ "        var $injector = angular.element(el).injector();\r\n" + "        if ($injector) {\r\n"
			+ "          return {$injector: $injector};\r\n" + "        }\r\n" + "      }\r\n"
			+ "    } catch(err) {}\r\n" + "  }\r\n" + "  function trySelector(selector) {\r\n"
			+ "    var els = document.querySelectorAll(selector);\r\n"
			+ "    for (var i = 0; i < els.length; i++) {\r\n" + "      var elHooks = tryEl(els[i]);\r\n"
			+ "      if (elHooks) {\r\n" + "        return elHooks;\r\n" + "      }\r\n" + "    }\r\n" + "  }\r\n"
			+ "\r\n" + "  if (selector) {\r\n" + "    return trySelector(selector);\r\n"
			+ "  } else if (window.__TESTABILITY__NG1_APP_ROOT_INJECTOR__) {\r\n"
			+ "    var $injector = window.__TESTABILITY__NG1_APP_ROOT_INJECTOR__;\r\n"
			+ "    var $$testability = null;\r\n" + "    try {\r\n"
			+ "      $$testability = $injector.get('$$testability');\r\n" + "    } catch (e) {}\r\n"
			+ "    return {$injector: $injector, $$testability: $$testability};\r\n" + "  } else {\r\n"
			+ "    return tryEl(document.body) ||\r\n"
			+ "        trySelector('[ng-app]') || trySelector('[ng\\\\:app]') ||\r\n"
			+ "        trySelector('[ng-controller]') || trySelector('[ng\\\\:controller]');\r\n" + "  }\r\n" + "}";

	public static final String WaitForAngular = GetNg1Hooks + "var rootSelector=arguments[0];\r\n"
			+ "var callback = arguments[1];\r\n" + "  try {\r\n"
			+ "    // Wait for both angular1 testability and angular2 testability.\r\n" + "\r\n"
			+ "    var testCallback = callback;\r\n" + "\r\n"
			+ "    // Wait for angular1 testability first and run waitForAngular2 as a callback\r\n"
			+ "    var waitForAngular1 = function(callback) {\r\n" + "\r\n" + "      if (window.angular) {\r\n"
			+ "        var hooks = getNg1Hooks(rootSelector);\r\n" + "        if (!hooks){\r\n"
			+ "          callback();  // not an angular1 app\r\n" + "        }\r\n" + "        else{\r\n"
			+ "          if (hooks.$$testability) {\r\n" + "            hooks.$$testability.whenStable(callback);\r\n"
			+ "          } else if (hooks.$injector) {\r\n" + "            hooks.$injector.get('$browser')\r\n"
			+ "                .notifyWhenNoOutstandingRequests(callback);\r\n"
			+ "          } else if (!rootSelector) {\r\n" + "            throw new Error(\r\n"
			+ "                'Could not automatically find injector on page: \"' +\r\n"
			+ "                window.location.toString() + '\".  Consider using config.rootEl');\r\n"
			+ "          } else {\r\n" + "            throw new Error(\r\n"
			+ "                'root element (' + rootSelector + ') has no injector.' +\r\n"
			+ "                ' this may mean it is not inside ng-app.');\r\n" + "          }\r\n" + "        }\r\n"
			+ "      }\r\n" + "      else {callback();}  // not an angular1 app\r\n" + "    };\r\n" + "\r\n"
			+ "    // Wait for Angular2 testability and then run test callback\r\n"
			+ "    var waitForAngular2 = function() {\r\n" + "      if (window.getAngularTestability) {\r\n"
			+ "        if (rootSelector) {\r\n" + "          var testability = null;\r\n"
			+ "          var el = document.querySelector(rootSelector);\r\n" + "          try{\r\n"
			+ "            testability = window.getAngularTestability(el);\r\n" + "          }\r\n"
			+ "          catch(e){}\r\n" + "          if (testability) {\r\n"
			+ "            testability.whenStable(testCallback);\r\n" + "            return;\r\n" + "          }\r\n"
			+ "        }\r\n" + "\r\n" + "        // Didn't specify root element or testability could not be found\r\n"
			+ "        // by rootSelector. This may happen in a hybrid app, which could have\r\n"
			+ "        // more than one root.\r\n"
			+ "        var testabilities = window.getAllAngularTestabilities();\r\n"
			+ "        var count = testabilities.length;\r\n" + "\r\n"
			+ "        // No angular2 testability, this happens when\r\n"
			+ "        // going to a hybrid page and going back to a pure angular1 page\r\n"
			+ "        if (count === 0) {\r\n" + "          testCallback();\r\n" + "          return;\r\n"
			+ "        }\r\n" + "\r\n" + "        var decrement = function() {\r\n" + "          count--;\r\n"
			+ "          if (count === 0) {\r\n" + "            testCallback();\r\n" + "          }\r\n"
			+ "        };\r\n" + "        testabilities.forEach(function(testability) {\r\n"
			+ "          testability.whenStable(decrement);\r\n" + "        });\r\n" + "\r\n" + "      }\r\n"
			+ "      else {testCallback();}  // not an angular2 app\r\n" + "    };\r\n" + "\r\n"
			+ "    if (!(window.angular) && !(window.getAngularTestability)) {\r\n" + "      // no testability hook\r\n"
			+ "      throw new Error(\r\n"
			+ "          'both angularJS testability and angular testability are undefined.' +\r\n"
			+ "          '  This could be either ' +\r\n"
			+ "          'because this is a non-angular page or because your test involves ' +\r\n"
			+ "          'client-side navigation, which can interfere with Protractor\\'s ' +\r\n"
			+ "          'bootstrapping.  See http://git.io/v4gXM for details');\r\n"
			+ "    } else {waitForAngular1(waitForAngular2);}  // Wait for angular1 and angular2\r\n"
			+ "                                                // Testability hooks sequentially\r\n" + "\r\n"
			+ "  } catch (err) {\r\n" + "    callback(err.message);\r\n" + "  }\r\n" + ";\r\n" + "";

	public static final String repeaterMatch = "function repeaterMatch(ngRepeat, repeater, exact) {\r\n"
			+ "  if (exact) {\r\n" + "    return ngRepeat.split(' track by ')[0].split(' as ')[0].split('|')[0].\r\n"
			+ "        split('=')[0].trim() == repeater;\r\n" + "  } else {\r\n"
			+ "    return ngRepeat.indexOf(repeater) != -1;\r\n" + "  }\r\n" + "};";

	/**
	 * Find elements by model name.
	 *
	 * @param {string}
	 *            model The model name.
	 * @param {Element}
	 *            using The scope of the search.
	 * @return {Array.<Element>} The matching elements.
	 */
	public static final String FindByModel = "var model=arguments[0];" + "var using = arguments[1] || document;\r\n"
			+ "  var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-', 'ng\\\\:'];\r\n"
			+ "  for (var p = 0; p < prefixes.length; ++p) {\r\n"
			+ "    var selector = '[' + prefixes[p] + 'model=\"' + model + '\"]';\r\n"
			+ "    var elements = using.querySelectorAll(selector);\r\n" + "    if (elements.length) {\r\n"
			+ "      return elements;\r\n" + "    }};";

	/**
	 * Find a list of elements in the page by their angular binding.
	 *
	 * arguments[0] {string} The binding, e.g. {{cat.name}}. arguments[1] {boolean}
	 * Whether the binding needs to be matched exactly arguments[2] {Element} The
	 * scope of the search.
	 *
	 * @return {Array.WebElement} The elements containing the binding.
	 */
	public static final String FindBindings = "var binding = arguments[0];\r\n" + "        var exactMatch = arguments[1];\r\n"
			+ "        var using = arguments[2] || document;\r\n" + "     \r\n"
			+ "        var bindings = using.getElementsByClassName('ng-binding');\r\n" + "        var matches = [];\r\n"
			+ "        for (var i = 0; i < bindings.length; ++i) {\r\n"
			+ "            var dataBinding = angular.element(bindings[i]).data('$binding');\r\n"
			+ "            if (dataBinding) {\r\n"
			+ "                var bindingName = dataBinding.exp || dataBinding[0].exp || dataBinding;\r\n"
			+ "                if (exactMatch) {\r\n"
			+ "                    var matcher = new RegExp('({|\\\\s|^|\\\\|)' +\r\n"
			+ "                        binding.replace(/[\\-\\[\\]\\/\\{\\}\\(\\)\\*\\+\\?\\.\\\\\\^\\$\\|]/g, '\\\\$&') +\r\n"
			+ "                        '(}|\\\\s|$|\\\\|)');\r\n"
			+ "                    if (matcher.test(bindingName)) {\r\n"
			+ "                        matches.push(bindings[i]);\r\n" + "                    }\r\n"
			+ "                } else {\r\n" + "                    if (bindingName.indexOf(binding) != -1) {\r\n"
			+ "                        matches.push(bindings[i]);\r\n" + "                    }\r\n"
			+ "                }\r\n" + "            }\r\n" + "        }\r\n" + "        return matches;";

	/**
	 * Find all rows of an ng-repeat.
	 *
	 * arguments[0] {string} The text of the repeater, e.g. 'cat in cats'.
	 * arguments[1] {boolean} Whether the repeater needs to be matched exactly
	 * arguments[1] {string} The selector to use for the root app element.
	 * arguments[2] {Element} The scope of the search.
	 *
	 * @return {Array.WebElement} All rows of the repeater.
	 */
	public static final String FindByRepeater = repeaterMatch + "\r\n" + "        var repeater = arguments[0];\r\n"
			+ "        var exactMatch = arguments[1];\r\n" + "        var using = arguments[2] || document;\r\n"
			+ "        var rows = [];\r\n"
			+ "        var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-', 'ng\\\\:'];\r\n"
			+ "        for (var p = 0; p < prefixes.length; ++p) {\r\n"
			+ "            var attr = prefixes[p] + 'repeat';\r\n"
			+ "            var repeatElems = using.querySelectorAll('[' + attr + ']');\r\n"
			+ "            attr = attr.replace(/\\\\/g, '');\r\n"
			+ "            for (var i = 0; i < repeatElems.length; ++i) {\r\n"
			+ "                if (repeaterMatch(repeatElems[i].getAttribute(attr), repeater, exactMatch)) {\r\n"
			+ "                    rows.push(repeatElems[i]);\r\n" + "                }\r\n" + "            }\r\n"
			+ "        }\r\n" + "        for (var p = 0; p < prefixes.length; ++p) {\r\n"
			+ "            var attr = prefixes[p] + 'repeat-start';\r\n"
			+ "            var repeatElems = using.querySelectorAll('[' + attr + ']');\r\n"
			+ "            attr = attr.replace(/\\\\/g, '');\r\n"
			+ "            for (var i = 0; i < repeatElems.length; ++i) {\r\n"
			+ "                if (repeaterMatch(repeatElems[i].getAttribute(attr), repeater, exactMatch)) {\r\n"
			+ "                    var elem = repeatElems[i];\r\n"
			+ "                    while (elem.nodeType != 8 || \r\n"
			+ "                            !repeaterMatch(elem.nodeValue, repeater)) {\r\n"
			+ "                        if (elem.nodeType == 1) {\r\n"
			+ "                            rows.push(elem);\r\n" + "                        }\r\n"
			+ "                        elem = elem.nextSibling;\r\n" + "                    }\r\n"
			+ "                }\r\n" + "            }\r\n" + "        }\r\n" + "  return rows;";

	/**
	 * Find elements by options.
	 *
	 * arguments[0] {string} optionsDescriptor The descriptor for the option (i.e.
	 * fruit for fruit in fruits). arguments[1] {Element} using The scope of the
	 * search.
	 *
	 * @return {Array.<Element>} The matching elements.
	 */
	public static final String FindByOptions = "  optionsDescriptor = arguments[0];\r\n"
			+ "        using = arguments[1] || document;\r\n"
			+ "        var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-', 'ng\\\\:'];\r\n"
			+ "        for (var p = 0; p < prefixes.length; ++p) {\r\n"
			+ "            var selector = '[' + prefixes[p] + 'options=\"\"' + optionsDescriptor + '\"\"] option';\r\n"
			+ "            var elements = using.querySelectorAll(selector);\r\n"
			+ "            if (elements.length) {\r\n" + "                return elements;\r\n" + "            }\r\n"
			+ "        };";
	/**
	 * Find buttons by textual content.
	 *
	 * arguments[0] {string} searchText The text to match. arguments[1] {boolean}
	 * Whether searchText needs to be matched exactly. arguments[2] {Element} using
	 * The scope of the search.
	 * 
	 * @return {Array.<Element>} The matching elements.
	 */
	public static final String FindByButtonText = " var searchText = arguments[0];\r\n"
			+ "            var exactMatch = arguments[1];\r\n" + "            var using = arguments[2] || document;\r\n"
			+ "            var elements = using.querySelectorAll('button', 'input[type=button]', 'input[type=submit]');\r\n"
			+ "            \r\n" + "            var matches = [];\r\n"
			+ "            for (var i = 0; i<elements.length; ++i) {\r\n"
			+ "                var element = elements[i];\r\n" + "                var elementText;\r\n"
			+ "                if (element.tagName.toLowerCase() == 'button') {\r\n"
			+ "                  elementText = element.textContent || element.innerText || '';\r\n"
			+ "                } else {\r\n" + "                  elementText = element.value;\r\n"
			+ "                }\r\n" + "\r\n"
			+ "                if (exactMatch == true && elementText.trim() === searchText) {\r\n"
			+ "                  matches.push(element);\r\n" + "                }\r\n"
			+ "                else if(exactMatch == false && elementText.indexOf(searchText) > -1) {\r\n"
			+ "                  matches.push(element);\r\n" + "                }\r\n" + "\r\n" + "            }\r\n"
			+ "                return matches;";

	/**
	 * Find elements by css selector and textual content.
	 *
	 * arguments[0] {string} cssSelector The css selector to match. arguments[1]
	 * {string} searchText The exact text to match or a serialized regex.
	 * arguments[2] {Element} using The scope of the search.
	 *
	 * @return {Array.<Element>} An array of matching elements.
	 */
	public static final String FindByCssContainingText = " var cssSelector = arguments[0];\r\n"
			+ "        using = arguments[2] || document;\r\n" + "        searchText = arguments[1];\r\n" + "\r\n"
			+ "        if (searchText.indexOf('__REGEXP__') === 0) {\r\n"
			+ "            var match = searchText.split('__REGEXP__')[1].match(/\\/ (.*)\\/ (.*) ?/);\r\n"
			+ "            searchText = new RegExp(match[1], match[2] || '');\r\n" + "        }\r\n"
			+ "        var elements = using.querySelectorAll(cssSelector);\r\n" + "        var matches = [];\r\n"
			+ "        for (var i = 0; i<elements.length; ++i) {\r\n" + "            var element = elements[i];\r\n"
			+ "            var elementText = element.textContent || element.innerText || '';\r\n"
			+ "            var elementMatches = searchText instanceof RegExp ?\r\n"
			+ "            searchText.test(elementText) :\r\n"
			+ "                elementText.indexOf(searchText) > -1;\r\n" + "\r\n"
			+ "                if (elementMatches) {\r\n" + "                    matches.push(element);\r\n"
			+ "                }\r\n" + "        }\r\n" + "        return matches;";

}
