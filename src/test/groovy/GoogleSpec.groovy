import spock.lang.*
import geb.*
import geb.spock.*

class GoogleSpec extends GebReportingSpec {

	def "the first link should be wikipedia"() {
		Browser browser = new Browser()
		String searchTerm = "Wikipedia"
		
		when:
        browser.go('http://www.google.com/')

        and:
		browser.$('input', name: 'q').value(searchTerm)
		browser.$('button', name: 'btnG').click()

        then:
        Thread.sleep(1000)
		def title = browser.page.title
		assert title.endsWith("Google Search") || title.endsWith("Cãutare Google")

		and:
		assert $('div#ires ol li')[0].find('a').text() == searchTerm
	}

}