Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html

  #get 'Route', to: 'ControllerName#ControllerAction'
  get '/calendars', to: 'calendars#index'

end
