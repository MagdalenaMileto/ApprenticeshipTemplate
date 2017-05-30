Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html

  resources :calendars, only: [:index, :show, :create, :update]
  get 'calendars/:id/holidays', to: 'calendars#get_holidays'
  post 'calendars/:id/holiday_rule', to: 'calendars#add_new_rule'
end
