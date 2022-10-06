### Extending another view binding parent class

```
@AndroidEntryPoint
class MeterReadingLandingOnceFragment : MeterReadingSelectOptionFragment() {

    override val viewModel: MeterScanViewModel by viewModels()

    override val containerLayoutId = R.layout.fragment_meter_reading_landing_once

    private lateinit var landingBinding: FragmentMeterReadingLandingOnceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        landingBinding = FragmentMeterReadingLandingOnceBinding.inflate(
            inflater,
            container,
            false
        )
        return landingBinding.root
    }

    override fun doBindings() {
        landingBinding.buttonSelfSubmission.setDebouncedOnClickListener {
            // todo event tracking
            navigateToSelfSubmission()
        }
        landingBinding.buttonOnBehalfSubmission.setDebouncedOnClickListener {
            // todo event tracking
            navigateToOnBehalfSubmission()
        }
        setHasOptionsMenu(true)
    }

    companion object {
        fun newInstance() = MeterReadingLandingOnceFragment()
    }
}
```
