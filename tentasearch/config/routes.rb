Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
	root 'university#index'
	get 'courses' => 'course#index'
	get 'course_show' => 'course#show'

end
