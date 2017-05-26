Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html

  resources :calendars, only: [:index, :show, :create, :update]
  resources :holiday_rules, path: 'calendars/holiday_rules', only: [:index]

  #Example: get 'Route', to: 'ControllerName#ControllerAction'
  #get '/calendarios', to: 'calendars#calendars'
  #get '/calendarios/:name', to: 'calendars#find_calendar_by_name'
  #get '/calendarios/:id', to: 'calendars#find_calendar_by_id'
end
