class CourseController < ApplicationController

	def index

	end

	def show
		path = File.expand_path('../../assets/data/courses/extq40/histogram', __FILE__)

		histogram = Hash[JSON.parse(File.read(path)).sort_by{|k, v| v}.reverse]

		words = histogram.keys
		

		@chart = LazyHighCharts::HighChart.new('graph') do |f|
		  f.title(text: params[:name])
		  f.xAxis(categories: words)
		  f.series(name: "Frequency", yAxis: 0, data: words.map { |word| histogram[word]})


		  f.legend(align: 'right', verticalAlign: 'top', y: 75, x: -50, layout: 'vertical')
		  f.chart({defaultSeriesType: "column"})
		end

		@chart_globals = LazyHighCharts::HighChartGlobals.new do |f|
		  f.global(useUTC: false)
		  f.chart(
		    backgroundColor: {
		      linearGradient: [0, 0, 500, 500],
		      stops: [
		        [0, "rgb(255, 255, 255)"],
		        [1, "rgb(240, 240, 255)"]
		      ]
		    },
		    borderWidth: 2,
		    plotBackgroundColor: "rgba(255, 255, 255, .9)",
		    plotShadow: true,
		    plotBorderWidth: 1
		  )
		  f.lang(thousandsSep: ",")
		  f.colors(["#90ed7d", "#f7a35c", "#8085e9", "#f15c80", "#e4d354"])
		end
	end

end
